import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContattoDao {

	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection con = DriverManager.getConnection(
				"jdbc:mariadb://localhost:3306/contattiDB", 
				"root", 
				"");
		return con;
	}
	
	private Contatto assegnavalori(ResultSet rs) throws SQLException {
		Contatto c = new Contatto();
		c.setId(rs.getInt("id"));
		c.setNome(rs.getString("nome"));
		c.setCognome(rs.getString("cognome"));
		c.setMail(rs.getString("mail"));
		c.setNumeroTelefono(rs.getString("numeroTelefono"));
		return c;
	}

	public List<Contatto> viewContatti() {
		List<Contatto> elenco = new ArrayList<Contatto>();
		try {
			Connection con = getConnection();
			Statement query = con.createStatement();
			String sql = "select * from contatti";
			ResultSet contatti = query.executeQuery(sql);
			while(contatti.next()) {
				elenco.add(assegnavalori(contatti));
			}
			query.close();
			con.close();
			contatti.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("si è verificato un errore");
		}
		return elenco;
	}
	
	
	public List<Contatto> viewContattiXNome(String nome) {
		List<Contatto> elenco = new ArrayList<Contatto>();
		try {
			Connection con = getConnection();
			Statement query = con.createStatement();
			String sql = "select * from contatti c where c.nome like '" + nome + "'" ;
			ResultSet contatti = query.executeQuery(sql);
			while(contatti.next()) {
				elenco.add(assegnavalori(contatti));
			}
			query.close();
			con.close();
			contatti.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("si è verificato un errore");
		}
		return elenco;
	}

	
	public List<Contatto> viewContattiXCognome(String cognome) {
		List<Contatto> elenco = new ArrayList<Contatto>();
		try {
			Connection con = getConnection();
			Statement query = con.createStatement();
			String sql = "select * from contatti c where c.cognome like '" + cognome + "'" ;
			ResultSet contatti = query.executeQuery(sql);
			while(contatti.next()) {
				elenco.add(assegnavalori(contatti));
			}
			query.close();
			con.close();
			contatti.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("si è verificato un errore");
		}
		return elenco;
	}

	
	public Contatto viewContattiXMail(String mail) {
		Contatto c = new Contatto();
		try {
			Connection con = getConnection();
			Statement query = con.createStatement();
			String sql = "select * from contatti c where c.mail like '" + mail + "'" ;
			ResultSet contatti = query.executeQuery(sql);
			contatti.next();
			c = assegnavalori(contatti);
			
			query.close();
			con.close();
			contatti.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("si è verificato un errore");
		}
		return c;
	}

	
	public Contatto viewContattiXTelefono(String num) {
		Contatto c = new Contatto();
		try {
			Connection con = getConnection();
			Statement query = con.createStatement();
			String sql = "select * from contatti c where c.numeroTelefono like '" + num + "'" ;
			ResultSet contatti = query.executeQuery(sql);
			contatti.next();
			c = assegnavalori(contatti);
			
			query.close();
			con.close();
			contatti.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("si è verificato un errore");
		}
		return c;
	}

	
	public void nuovo(String nome, String cognome, String mail, String num) {
		System.out.println(nome);
		System.out.println(cognome);
		System.out.println(mail);
		System.out.println(num);
		try {
			Connection con = getConnection();
			Statement query = con.createStatement();
			String sql = "INSERT INTO contatti (";
			int[] cod = new int[3]; cod[0] = -1; cod[1] = -1; cod[2] = -1;
			if(nome != null && cognome == null && mail == null && num == null) {
				sql  += "nome";
				cod[0] = 0;
			}
			if(nome != null && (cognome != null || mail != null || num != null)) {
				sql  += "nome, ";
				cod[0] = 1;
			}	
			if(cognome != null && mail == null && num == null) {
				sql  += "cognome";
				cod[1] = 0;
			}
			if(cognome != null && (mail != null || num != null)) {
				sql  += "cognome, ";
				cod[1] = 1;
			}		
			if(mail != null && num == null) {
				sql  += "mail";
				cod[2] = 0;
			}
			if(mail != null && num != null) {
				sql  += "mail, ";
				cod[2] = 1;
			}
			if( num != null) {
				sql  += "num ";
			}	
			sql += ") VALUES ( '";
			if(cod[0] == 0 ) {
				sql += nome + "' ";
			}
			if(cod[0] == 1 ) {
				sql += nome + "', ";
			}
			if(cod[1] == 0  ) {
				sql += "'" + cognome + "' ";
			}
			if(cod[1] == 1  ) {
				sql += "'" + cognome + "', ";
			}
			if(cod[2] == 0  ) {
				sql += "'" + mail + "' ";
			}
			if(cod[2] == 1 ) {
				sql += "'" + mail + "', ";
			}	
			if(num != null) {
				sql += "'" + num + "'";
				sql += ");";
			}
			System.out.println(sql);
			//query.executeUpdate(sql);
			query.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void elimina(String mail, String num) {
		try {
			Connection con = getConnection();
			Statement query = con.createStatement();
			String sql;
			//se ho nserito una mail
			if(mail != null) {
			sql = "delete from contatti where mail like '" + mail + "'";
			}
			
			//se ho nserito un telefono
			if(num != null) {
				sql = "delete from contatti where numeroTelefono like '" + num + "'";
			}
			
			else {
				sql = "Si è verificato un errore nella composizione della query";
			}
			
			query.executeUpdate(sql);
			query.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	}
	
	
	public void aggiorna(String selector, String newnome, String newcognome, String newmail, String newnum) {
		try {
		Connection con = getConnection();
		Statement query = con.createStatement();
		String sql = "UPDATE contatti SET ";
		
		//se ho inserito un nuovo nome e nessun cognome, mail, numero
		if(newnome != null && newcognome == null && newmail == null && newnum == null) {
		sql += "nome = " + "'" + newnome + "' ";
		}
		
		//se ho inserito un nuovo nome e qualocos'altro dopo (cognome o mail o nomero)
		if(newnome != null && (newcognome != null || newmail != null || newnum != null)) {
			sql += "nome = " + "'" + newnome + "', ";
		}
		
		//se ho inserito un nuovo cognome e nessuna mail, numero
		if(newcognome != null && newmail == null && newnum == null) {
			sql += "cognome = " + "'" + newcognome + "' ";
			}
		
		//se ho inserito un nuovo nome e qualocos'altro dopo (mail o nomero)
		if(newcognome != null  && (newmail != null || newnum != null)) {
			sql += "cognome = " + "'" + newcognome + "', ";
				
		}
		
		//se ho inserito una nuova mail e nessun numero
		if(newmail != null && newnum == null) {
			sql += "mail = " + "'" + newmail + "' ";
			}
			
		//se ho inserito una nuova mail e un numero
		if(newmail != null && newnum != null) {
				sql += "mail = " + "'" + newmail + "', ";
			}
		
		//se ho inserito un nuovo numero
		if(newnum != null) {
				sql += "numeroTelefono = " + "'" + newnum + "' ";
				}
			
		sql += "WHERE ";
		
		//se ho nserito una mail
		if(selector.contains("@")) {
		sql += "mail = " + "'" + selector + "';";
		}
		
		//se ho nserito un telefono
		else if(CommandLine.isPhone(selector)) {
			sql += "numeroTelefono = " + "'" + selector + "';";
		}
		else {
			sql = "Si è verificato un errore nella composizione della query";
		}
		
		
		
		
		
	
		query.executeUpdate(sql);
		query.close();
		con.close();
		
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}	
	}
}


	


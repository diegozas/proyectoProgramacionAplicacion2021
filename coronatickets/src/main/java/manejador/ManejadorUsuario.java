package manejador;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import logica.Artista;
import logica.Espectador;
import logica.Usuario;
import persistencia.Conexion;

public class ManejadorUsuario {
	private static ManejadorUsuario instancia=null;
	//private List<Usuario> usuarios=new ArrayList<>();

	private ManejadorUsuario (){}
	
	public static ManejadorUsuario getInstancia(){
		if(instancia==null)
			instancia=new ManejadorUsuario();
		return instancia;
	}
	
	public void agregarUsuario(Usuario u) {
		//usuarios.add(u);
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(u);
		
		em.getTransaction().commit();
	
	
	}
	
	
	public Artista buscarArtista(String nick) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Artista retorno= (Artista) em.find(Usuario.class, nick);
		return retorno;
	
	}
	
	
	public Espectador buscarEspectador(String nick) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Espectador retorno= (Espectador) em.find(Usuario.class, nick);
		return retorno;
	
	}
	
	public Usuario getUsuario(String s) {
		Usuario retorno=null;
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select u from Usuario u");
		List<Usuario> listaUsuario = (List<Usuario>) query.getResultList();
		for(Usuario u:listaUsuario) {
			if(u.getCorreoElectronico().equals(s)||u.getNickname().equals(s)){
				retorno=u;
			}
		}
		
		return retorno;
	}
	
	public boolean existeUsuario(String email,String nickname) {
			boolean existe=false;
			
			Conexion conexion = Conexion.getInstancia();
			EntityManager em = conexion.getEntityManager();
			
			Query query = em.createQuery("select u from Usuario u");
			List<Usuario> listaUsuario = (List<Usuario>) query.getResultList();
			for(Usuario u:listaUsuario) {
				if(u.getCorreoElectronico().equals(email)||u.getNickname().equals(nickname)){
				existe=true;
				}
			}
		return existe;
	}
	
	
	public boolean existeUsuarioPassword(String log,String pass) {
		boolean existe=false;
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select u from Usuario u");
		List<Usuario> listaUsuario = (List<Usuario>) query.getResultList();
		if(!listaUsuario.isEmpty()) {
			for(Usuario u:listaUsuario) {
				if((u.getCorreoElectronico().equals(log)||u.getNickname().equals(log)) && u.getPassword().equals(pass)){
					existe=true;
				}
			}
		}
	return existe;
}

	
	@SuppressWarnings("null")
	public ArrayList<String> getNickUsuarios(){
		ArrayList<String> nickUsuarios=new ArrayList<String>();
		
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select u from Usuario u");
		List<Usuario> listaUsuario = (List<Usuario>) query.getResultList();
		
		for(Usuario u:listaUsuario) {
			nickUsuarios.add(u.getNickname());
		}
		return nickUsuarios;
	}
	
	
	public List<String> nickEspectadores(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select u from Usuario u");
		List<Usuario> listaUsuario = (List<Usuario>) query.getResultList();
		
		
		List<String> listaNicks = new ArrayList<String>();
		for(Usuario u:listaUsuario) {
			if(u instanceof Espectador) {
				listaNicks.add(u.getNickname());
			}
		}
		return listaNicks;
		
		
	}
	
	
	
	
	//funcion array list que devuelva los nickname de artistas
	public ArrayList<String> arrayNombArtista(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select u from Usuario u");
		List<Usuario> listaUsuario = (List<Usuario>) query.getResultList();
		
		
		ArrayList<String> listaNicks = new ArrayList<String>();
		for(Usuario u:listaUsuario) {
			if(u instanceof Artista) {
				if(!((Artista) u).getInvitado())
				listaNicks.add(u.getNickname());
			}
		}
		return listaNicks;
	}

	/*public boolean hayUsuarios() {
		if(this.usuarios.isEmpty()) {
			return false;
		}else {
			return true;
		}

	}

	public List<String> listarUsuariosNick() {
		List<String> lali = new ArrayList<>();
		String nick;
		for(Usuario u : this.usuarios) {
			nick = u.getNickname();
			lali.add(nick);
		}
		return lali;
	}


*/






















}

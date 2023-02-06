package model;

public class Usuarios {
	
	 private int id;

	    private String nombre;

	    private String password;

		public Usuarios(String nombre, String password) {
			super();
			this.nombre = nombre;
			this.password = password;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	    
	    
}

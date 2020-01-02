package jansec;



public class User {

		private int user_id;
		private String username;
		private String password;
		private String email;
		private Role role_id;
		private String contact_number;
		
		public User(int user_id, String name, String username, String password, String email, Role role_id,
				String contact_number) {
			this.user_id = user_id;
			
			this.username = username;
			this.password = password;
			this.email = email;
			this.role_id = role_id;
			this.contact_number = contact_number;
		}
		
		public String getMobileNumber() {
			return contact_number;
		}

		public void setMobileNumber(String contact_number) {
			this.contact_number = contact_number;
		}

		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Role getRole_id() {
			return role_id;
		}
		public void setRole_id(Role role_id) {
			this.role_id = role_id;
		}
		
		@Override
		public String toString() {
			String pass = "";
			for(int i=0;i<password.length();i++) {
				pass+="*";
			}
			
			
			return "User [user_id=" + user_id + ", username=" + username + ", password=" + pass
					+ ", email=" + email + ", role_id=" + role_id.getName() + ", contact_number=" + contact_number + "]";
		}
		
		
}
package server;

        import java.util.Arrays;
        import java.util.Objects;

public class UserServer {
    private String username;
    //private String email;
    //private byte[] passwordHash;

    public UserServer(String username) {
        this.username = username;
        //this.email = email;
        //this.passwordHash = username.getBytes();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public String getEmail() {
//        return email;
//    }

//    public void setEmail(String email) {
//        this.email = email;
//    }

//    public byte[] getPasswordHash() {
//        return passwordHash;
//    }

//     public void setPasswordHash(byte[] passwordHash) {
//        this.passwordHash = passwordHash;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserServer userServer = (UserServer) o;
       return username.equals(userServer.username) //&&
//                email.equals(userServer.email) &&
//                Arrays.equals(passwordHash, userServer.passwordHash)
              ;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(username);
        result = 31 * result;
        return result;
    }
}
package dsd.security.utils;

public interface ISqlQueries {

    default String getUserByUsername(){
        return "SELECT username, password, enabled FROM ss.users WHERE username = ?";
    }

    default String getAuthorityByUsername(){
        return "SELECT username, authority FROM ss.authorities WHERE username = ?";
    }

}

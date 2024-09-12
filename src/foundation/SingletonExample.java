package foundation;

import java.io.Serializable;

public class SingletonExample {

    // Factory class to manage the singleton instance creation
    public static class FactoryClass {

        // The singleton instance
        private static dbConnectionSQL connection = null;

        // Private constructor to prevent instantiation
        private FactoryClass() {
        }

        // Method to get the singleton instance
        public static dbConnectionSQL create(int id, String username, String password, String url) {
            if (connection == null) {
                connection = new dbConnectionSQL(id, username, password, url);
            }
            return connection;
        }
    }

    // Interface for database connection
    public interface databaseConnection {
        // Add any required methods for the interface
    }

    // Singleton database connection class
    public static class dbConnectionSQL implements Serializable, databaseConnection {

        private int id;
        private String url;
        private String username;
        private String password;

        // Private constructor to prevent instantiation
        private dbConnectionSQL(int id, String url, String username, String password) {
            this.id = id;
            this.url = url;
            this.username = username;
            this.password = password;
        }

        // Getter methods for the properties
        public int getId() {
            return id;
        }

        public String getUrl() {
            return url;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public static void main(String[] args) {
        // Create or get the singleton instance
        dbConnectionSQL db = FactoryClass.create(1, "username", "password", "url");
        // Use the singleton instance
        System.out.println("ID: " + db.getId());
        System.out.println("URL: " + db.getUrl());
    }
}


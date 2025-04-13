module quiz {
    requires java.sql; // Required for JDBC connection
    opens quiz; // Allows JavaFX or other libraries to access this package
    requires java.desktop; // Required for Swing and AWT

}

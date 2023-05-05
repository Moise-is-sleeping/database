import java.sql.*
fun main() {
    // val url = "jdbc:mysql://localhost:3306/sakila"
//jdbc:oracle:thin:@//localhost:1521:xe
    val url = "jdbc:oracle:thin:@localhost:1521:xe"
    val usuario = "alumno"
    val contraseña = "alumno"
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver")
        val conexion = DriverManager.getConnection(url, usuario, contraseña)
        println("Conexión exitosa")
        val stmt = conexion.prepareStatement("INSERT INTO LIBROS  (TITULO , AUTOR , EDITORIAL,PAGINA ) VALUES (?, ?, ?,?)")
        stmt.setString(1, "Lucia la")
        stmt.setString(2, "adrian")
        stmt.setString(3, "yomama")
        stmt.setInt(4, 234)
        stmt.executeUpdate()
        println("Inserción exitosa")
        conexion.close()
    } catch (e: SQLException) {
        println("Error en la conexión: ${e.message}")
    } catch (e: ClassNotFoundException) {
        println("No se encontró el driver JDBC: ${e.message}")
    }


}

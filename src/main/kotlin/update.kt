
import java.sql.*
fun main() {
    // val url = "jdbc:mysql://localhost:3306/sakila"
//jdbc:oracle:thin:@//localhost:1521:xe
    val url = "jdbc:oracle:thin:@localhost:1521:xe"
    val usuario = "alumno"
    val contraseña = "alumno"
    try {
        val connection = DriverManager.getConnection(url, "alumno", "alumno")
        val sql = "UPDATE LIBROS SET TITULO = ? WHERE AUTOR = ?"


        val statement = connection.prepareStatement(sql)
        statement.setString(1, "lucianpc")
        statement.setString(2, "adrian")
        val rowsUpdated = statement.executeUpdate()
        if (rowsUpdated > 0) {
            println("El registro ha sido actualizado exitosamente.")
        } else {
            println("No se ha actualizado ningún registro.")
        }
        statement.close()
        connection.close()
    } catch (e: SQLException) {
        println("Error en la conexión: ${e.message}")
    } catch (e: ClassNotFoundException) {
        println("No se encontró el driver JDBC: ${e.message}")
    }


}
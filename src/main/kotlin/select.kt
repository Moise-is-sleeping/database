import java.sql.*
import javax.print.DocFlavor.STRING

fun main() {
    // val url = "jdbc:mysql://localhost:3306/sakila"
//jdbc:oracle:thin:@//localhost:1521:xe
    val url = "jdbc:oracle:thin:@localhost:1521:xe"
    val usuario = "alumno"
    val contraseña = "alumno"
    try {
        val connection = DriverManager.getConnection(url, "alumno", "alumno")
        val query = "SELECT TITULO FROM LIBROS"
        val statement = connection.prepareStatement(query)
        val resutls  = statement.executeQuery(query)
        val stuff = mutableListOf<String>()
        while(resutls.next()){
            println(resutls.getString("TITULO"))
        }
        resutls.close()
        statement.close()
        connection.close()
    } catch (e: SQLException) {
        println("Error en la conexión: ${e.message}")
    } catch (e: ClassNotFoundException) {
        println("No se encontró el driver JDBC: ${e.message}")
    }


}
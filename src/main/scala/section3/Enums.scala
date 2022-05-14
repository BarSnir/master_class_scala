package section3

object Enums extends App {
    // sealed datatype
    enum Permission {
        case READ, WRITE, EXECUTE, NONE
        def open: Unit = {
            if (this == READ) println("Open doc...")
            else println("Permission dined!")
        }
    }

    val somePermissions: Permission = Permission.READ
    somePermissions.open
}
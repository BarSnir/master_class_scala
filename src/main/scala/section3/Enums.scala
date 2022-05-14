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

    enum PermissionWithBIts(bit: Int) {
        case READ extends PermissionWithBIts(4)
        case WRITE extends PermissionWithBIts(2)
        case EXECUTE extends PermissionWithBIts(1)
        case NONE extends PermissionWithBIts(0)
    }

    object PermissionWithBIts {
        def fromBits(bits: Int): PermissionWithBIts = PermissionWithBIts.NONE
    }

    // enum indexing
    val somePermission2 = somePermissions.ordinal
    val allPermission = PermissionWithBIts.values
    val readPermission = PermissionWithBIts.valueOf("READ")
    println(somePermission2)
    println(allPermission)
    println(readPermission)
}
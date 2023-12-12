package pagao.creditapi.exception

data class BussinesException(override val message: String?): RuntimeException(message)

package school.cactus.succulentshop

class IdentityValidator : Validator() {

    override fun isValid(field: String): Boolean {
        val emailValidator = EmailValidator()
        if (!emailValidator.isValid(field)) {
            error = emailValidator.getError()
            return UsernameValidator().isValid(field)
        }
        return true
    }

}
package school.cactus.succulentshop

import org.junit.Test
import org.junit.Assert.*

class ValidationTest {

    private val identityValidator = IdentityValidator()
    private val emailValidator = EmailValidator()
    private val usernameValidator = UsernameValidator()
    private val passwordValidator = PasswordValidator()


    @Test
    fun isNotEmpty() {

        assertEquals(false, passwordValidator.isNotEmpty(""))

        assertEquals(true, emailValidator.isNotEmpty("hasan"))
        assertEquals(true, usernameValidator.isNotEmpty("hasan"))
        assertEquals(true, identityValidator.isNotEmpty("hasan"))
        assertEquals(true, passwordValidator.isNotEmpty("hasan"))

    }

    @Test
    fun isLonger() {

        assertEquals(false, emailValidator.isLonger(EmailValidator.MIN_LEN,"has"))
        assertEquals(true, emailValidator.isLonger(EmailValidator.MIN_LEN,"hasan01@gmail.com"))
        assertEquals(true, emailValidator.isLonger(EmailValidator.MIN_LEN,"hasan@gmail.com"))


        assertEquals(false, usernameValidator.isLonger(UsernameValidator.MIN_LEN,"h"))
        assertEquals(true, usernameValidator.isLonger(UsernameValidator.MIN_LEN,"hasan"))
        assertEquals(true, usernameValidator.isLonger(UsernameValidator.MIN_LEN,"hasan_01"))

        assertEquals(false, passwordValidator.isLonger(PasswordValidator.MIN_LEN,"hasan"))
        assertEquals(true, passwordValidator.isLonger(PasswordValidator.MIN_LEN,"hasan123"))
        assertEquals(true, passwordValidator.isLonger(PasswordValidator.MIN_LEN,"Hasan_01"))

    }

    @Test
    fun isShorter() {

        assertEquals(false, emailValidator
            .isShorter(EmailValidator.MAX_LEN,"hasan01hasan01hasan01hasan01hasan01hasan01hasan01@gmail.com"))
        assertEquals(true, emailValidator
            .isShorter(EmailValidator.MAX_LEN,"hasan@gmail.com"))


        assertEquals(false, usernameValidator
            .isShorter(UsernameValidator.MAX_LEN,"hasanhasanhasanhasanhasan"))
        assertEquals(true, usernameValidator
            .isShorter(UsernameValidator.MAX_LEN,"hasan"))

        assertEquals(false, passwordValidator
            .isShorter(PasswordValidator.MAX_LEN,"hasanhasanhasanhasanhasanhasanhasanhasan"))
        assertEquals(true, passwordValidator
            .isShorter(PasswordValidator.MAX_LEN,"hasan123"))

    }


    @Test
    fun isValid() {

//        EmailValidator

        assertEquals(false, emailValidator.isValid("hasangmail.com"))
        assertEquals(false, emailValidator.isValid("hasan"))
        assertEquals(false, emailValidator.isValid("abcd"))
        assertEquals(false, emailValidator.isValid("@.ööö"))

        assertEquals(true, emailValidator.isValid("hasan@gmail.com"))
        assertEquals(true, emailValidator.isValid("hasan_01@gmail.com"))

//        UsernameValidator

        assertEquals(false, usernameValidator.isValid("hasan@gmail.com"))
        assertEquals(false, usernameValidator.isValid("hasan01?"))
        assertEquals(false, usernameValidator.isValid("Hasan"))

        assertEquals(true, usernameValidator.isValid("hasan"))
        assertEquals(true, usernameValidator.isValid("has"))
        assertEquals(true, usernameValidator.isValid("hasan01"))
        assertEquals(true, usernameValidator.isValid("hasan01_"))
        assertEquals(true, usernameValidator.isValid("hasan01__"))

//        IdentityValidator

        assertEquals(false, identityValidator.isValid("hasan01?"))
        assertEquals(false, identityValidator.isValid("1"))
        assertEquals(false, identityValidator.isValid("Hasan"))

        assertEquals(true, identityValidator.isValid("hasan"))
        assertEquals(true, identityValidator.isValid("hasan@gmail.com"))
        assertEquals(true, identityValidator.isValid("hasan01"))
        assertEquals(true, identityValidator.isValid("hasan01_"))
        assertEquals(true, identityValidator.isValid("hasan01__"))

//        PasswordValidator

        assertEquals(false, passwordValidator.isValid("hasan"))
        assertEquals(false, passwordValidator.isValid("hasanhasan"))
        assertEquals(false, passwordValidator.isValid("hasanHasan"))
        assertEquals(false, passwordValidator.isValid("hasanHasan01"))
        assertEquals(false, passwordValidator.isValid("01hasaNç"))

        assertEquals(true, passwordValidator.isValid("hasanHasan01?"))
        assertEquals(true, passwordValidator.isValid("Hasan01_"))
        assertEquals(true, passwordValidator.isValid("01hasaNç."))

    }
}
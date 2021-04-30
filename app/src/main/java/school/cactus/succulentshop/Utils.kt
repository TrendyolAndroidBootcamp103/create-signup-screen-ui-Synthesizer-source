package school.cactus.succulentshop

import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.validate(validator: Validator) {
    val res = validator.isValid(editText!!.text.toString())
    if (validator.getError() != Validator.SUCCESS) error =
        this.context.resources.getString(validator.getError())
    isErrorEnabled = !res
}
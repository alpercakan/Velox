package com.alpercakan.errormessagehelper

import android.content.res.Resources
import com.isbugun.android.R
import java.util.*

object ErrorMessageHelper {
    private val ERROR_MESSAGES_XML_BASE_NAME = "error_message_"
    private val ERROR_TITLES_XML_BASE_NAME = "error_title_"

    lateinit var resources: Resources
    lateinit var packageName: String

    private fun getPair(id1: Int, id2: Int) = Pair(resources.getString(id1),
            resources.getString(id2))

    /**
     * @return (message, title)
     */
    fun getErrorMessageAndTitle(errorType: ErrorType): Pair<String, String> {
        val messageResourceID: Int? = resources.getIdentifier(
                ERROR_MESSAGES_XML_BASE_NAME + errorType.name.toLowerCase(Locale("EN")),
                "string",
                packageName)

        val titleResourceID: Int? = resources.getIdentifier(
                ERROR_TITLES_XML_BASE_NAME + errorType.name.toLowerCase(Locale("EN")),
                "string",
                packageName)

        if (messageResourceID == null ||
                titleResourceID == null ||
                errorType == ErrorType.ERROR_MESSAGE_IS_NULL) {
            return getPair(R.string.unidentified_error_message, R.string.unidentified_error_title)
        }

        return getPair(messageResourceID, titleResourceID)
    }

    fun getErrorMessage(errorType: ErrorType) = getErrorMessageAndTitle(errorType).first

    fun getErrorTitle(errorType: ErrorType) = getErrorMessageAndTitle(errorType).second

    enum class ErrorType(val type: Int) {
        /*
         * Write error types here. For example, following error type will be mapped to "error_message_user_name_cannot_be_null"
         * and "error_title_user_name_cannot_be_null" from the strings.xml
         */
        USER_NAME_CANNOT_BE_NULL(0)
    }
}

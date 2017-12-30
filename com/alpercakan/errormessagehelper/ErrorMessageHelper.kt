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
        USER_TOKEN_CANNOT_BE_NULL(0),
        USER_ID_CANNOT_BE_NULL(1),
        CHAT_MESSAGE_LENGTH_EXCEEDS_MAXIMUM(2),
        NULL_RESPONSE(3),
        PUSHER_AUTH_TOKEN_CANNOT_BE_NULL(4),
        PUSHER_EVENT_DATA_CANNOT_BE_NULL(5),
        CHAT_MESSAGE_CONTENT_CANNOT_BE_NULL(6),
        CHAT_MESSAGE_TIME_CANNOT_BE_NULL(7),
        USER_NAME_CANNOT_BE_NULL(8),
        USER_SURNAME_CANNOT_BE_NULL(9),
        COMPANY_NAME_CANNOT_BE_NULL(10),
        VIEW_NOT_CONNECTED(11),
        LAST_SEEN_CANNOT_BE_NULL(12),
        LATITUDE_CANNOT_BE_NULL(13),
        LONGITUDE_CANNOT_BE_NULL(14),
        PROFILE_TYPE_ILLEGAL(15),
        TAB_INDEX_IS_OUT_OF_BOUNDS(16),
        JOB_ID_CANNOT_BE_NULL(17),
        JOB_APPLICATION_STATUS_CANNOT_BE_NULL(18),
        JOB_DISTANCE_CANNOT_BE_NULL(19),
        JOB_TITLE_CANNOT_BE_NULL(20),
        CREATION_TIME_CANNOT_BE_NULL(21),
        ERROR_MESSAGE_IS_NULL(22),
        PROFILE_CANNOT_BE_NULL(23),
        CHAT_ID_CANNOT_BE_NULL(24),
        JOB_DESCRIPTION_CANNOT_BE_NULL(25),
        CATEGORY_NAME_CANNOT_BE_NULL(26),
        APPLICATION_ID_CANNOT_BE_NULL(27),
        JOB_SEARCH_FAILED(28),
        MAP_FRAGMENT_NULL(29),
        CONNECTION_PROBLEM(30),
        MAP_NO_LOCATION_FOUND_WITH_THE_QUERY(31),
        MAP_LOCATION_SEARCH_PROBLEM(32)
    }
}
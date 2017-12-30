# Velox
A developer-friendly, very small library written in Kotlin for Android, which allows you to handle errors in your app just by defining one-line exception classes. Using this library, you can easily retrieve translated error message and title from the resources.

**Current version is only enum-based, i.e., you add your error types to the enum in the library. In very short time, it will be turned in to the version mentioned above.**

## Current Usage

- Add your error type `MY_ERROR_TYPE` to the enum inside the library. Use only uppercase letters and underscores for seperating words.
- Add the error message and the error title (and their translations) to the `strings.xml` files with keys `"error_message_my_error_type"` and `"error_title_my_error_type"`.
- In the onCreate of Application, set the `resources` and `packageName` variables which reside inside the `ErrorMessageHelper` singleton. At exit, set the first one to `null` in order to prevent possible memory leaks.
- Now you can simply retrieve message and title from anywhere in your code calling `ErrorMessageHelper.getErrorMessageAndTitle(ErrorType.MY_ERROR_TYPE)`, which returns a pair of strings `(message, title)`.

## Planned Usage

- Create a class MyErrorType which implements `com.alpercakan.errormessagehelper.ErrorMessageHelper.ErrorType` interface. Use UpperCamelCase (i.e., PascalCase) for naming.
- Add the error message and the error title (and their translations) to the `strings.xml` files with keys `"error_message_my_error_type"` and `"error_title_my_error_type"`.
- In the onCreate of Application, set the `resources` and `packageName` variables which reside inside the `ErrorMessageHelper` singleton. At exit, set the first one to `null` in order to prevent possible memory leaks.
- Now you can simply retrieve message and title from anywhere in your code calling `ErrorMessageHelper.getErrorMessageAndTitle(MyErrorType)`, which returns a pair of strings `(message, title)`.

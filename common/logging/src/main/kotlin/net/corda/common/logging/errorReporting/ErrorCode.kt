package net.corda.common.logging.errorReporting

/**
 * A type representing an error condition.
 *
 * Error codes should be used in situations where an error is expected and information can be provided back to the user about what they've
 * done wrong. Each error code should have a resource bundle defined for it, which contains set of properties that define the error string
 * in different languages. See the resource bundles in node/src/main/resources/errorReporting for more details.
 */
interface ErrorCode<NAMESPACE: Enum<NAMESPACE>, ERROR: Enum<ERROR>> {
    /**
     * The namespace of this error code.
     *
     * Namespaces are used to ensure that particular codes for different feature areas do not clash. A namespace should
     * provide a short description of the code area that triggered this error, e.g. "attachments" or "metering"
     */
    val namespace: Enum<NAMESPACE>

    /**
     * The error code.
     *
     * Error codes are used to indicate what sort of error occurred. A unique code should be returned for each possible
     * error condition that could be reported within the defined namespace. The code should very briefly describe what has gone wrong, e.g.
     * "failed-to-store" or "connection-unavailable".
     */
    val code: Enum<ERROR>

    /**
     * Parameters to pass to the string template when reporting this error. The corresponding template that defines the error string in the
     * resource bundle must be expecting this set of parameters.
     */
    val parameters: List<Any>
}
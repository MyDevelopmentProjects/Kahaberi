package ge.unknown.utils.constants;

import java.io.File;

/**
 * Created by MJaniko on 10/26/2016.
 */
public class Constants {
    public static final class UploadHelpers {
        private static final String HOME = String.format("%s%s", System.getProperty("user.home"), File.separator);
        public static final String UPLOADS = String.format("%s%s%s", HOME, "uploads", File.separator);
        public static final String USER_IMG = String.format("%s%s", UPLOADS, "user");
    }

    public static final class ErrorCodes {
        public class ErrorResponse {
            public static final String ACCESS_IS_DENIED = "access_is_denied";
            public static final String UNKNOWN = "unknown";
            public static final String DUPLICATE_RECORD = "DUPLICATE_RECORD";
            public static final String RECORD_IS_USED_IN_OTHER_TABLES = "RECORD_IS_USED_IN_OTHER_TABLES";
            public static final String PERSISTENCE_EXCEPTION = "javax.persistence.PersistenceException";
        }
    }

    public static final class ControllerCodes {
        public static final String STRING_EMPTY = "";
        public static final String PAGE_NUMBER = "pageNumber";
        public static final String PAGE_NUMBER_DEFAULT_VALUE = "0";
        public static final String PAGE_SIZE_DEFAULT_VALUE = "10";
        public static final String IS_ASCENDING_DEFAULT_VALUE = "true";
        public static final String DEFAULT_SORT_BY = "id";

        public static final String SLASH = "/";
        public static final String LIST = "list";
        public static final String LAYOUT = "layout";
        public static final String PUT = "put";
        public static final String DELETE = "delete";
        public static final String UPDATE = "update";
        public static final String KEY = "key";
        public static final String VALUE = "value";
    }
}

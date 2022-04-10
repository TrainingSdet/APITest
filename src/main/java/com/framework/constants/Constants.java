package com.framework.constants;

public class Constants {

	public static final String X_PAYLOAD_ENCRYPTION_KEY="payload-encryption-key";
	
	/** Count constants. */
	public static final int ONE_COUNT = 1;
	public static final int TWO_COUNT = 2;
	public static final int MAX_SKIP_COUNT = 500;
	public static final int COUNT_200 = 200;
	public static final int COUNT_10K = 10000;

	/** YSL API Query param filters - Constants */
	public static final String PROVIDER_ID_FILTER = "providerId";
	public static final String STATUS_FILTER = "status";
	public static final String CONTAINER_FILTER = "container";
	public static final String PROVIDER_ACCOUNT_ID_FILTER = "providerAccountId";
	public static final String ACCOUNT_RECON_TYPE_FILTER = "accountReconType";
	public static final String MULTIPLE_PROVIDER_ACCOUNT_IDS = "providerAccountIds";
	public static final String SKIP_FILTER = "skip";
	public static final String TOP_FILTER = "top";
	public static final String INCLUDE_FILTER = "include";
	public static final String ACCOUNT_ID_FILTER = "accountId";
	public static final String FROM_DATE_FILTER = "fromDate";
	public static final String TO_DATE_FILTER = "toDate";
	public static final String INTERVAL_FILTER = "interval";
	public static final String INCLUDE_CF_FILTER = "includeCF";
	public static final String MULTIPLE_ACCOUNT_IDS_FILTER = "accountIds";
	public static final String CLASSIFICATION_TYPE_FILTER = "classificationType";
	public static final String CLASSIFICATION_VALUE_FILTER = "classificationValue";
	public static final String ASSET_CLASSIFICATION_TYPE = "assetClassification.classificationType";
	public static final String HOLDING_TYPE = "holdingType";
	public final static String INCLUDE_FILTER_VALUE = "credentials";

	/** Key Value constants. */
	public final static String FEEDER = "feeder";
	public static final String PATH_SEPARATOR = "/";
	public static final String FIELD = "field";
	public static final String ID = "id";
	public static final String VALUE = "value";
	public static final String PROVIDER = "provider";
	public static final String LOGIN_FORM = "loginForm";
	public static final String ROW = "row";
	public static final String DATA_SET = "dataset";
	public static final String DATA_SET_NAME = "datasetName";// Added for B-06410 story
	public static final String RANDOM_STRING = "abcd";
	public static final String TYPE = "type";
	public static final String PASSWORD = "password";
	public static final String TEXT = "text";
	public static final String FORMAT = "FORMAT";
	public static final String IS_OPTIONAL = "isOptional";
	public static final String TOKEN = "token";
	public static final String EMPTY_STRING = "";
	public static final String UNDERSCORE = "_";
	public static final String LOGIN_NAME = "loginName";
	public static final String QN_ANS_1 = "SQandA--QUESTION_1--1";
	public static final String QN_ANS_2 = "SQandA--QUESTION_2--2";
	public static final String CREDENTIALS = "credentials";
	public static final String NAME = "name";
	public static final String NAME_LOGIN = "LOGIN";
	public static final String NAME_PASSWORD = "PASSWORD";
	public static final String NAME_PASSWORD1 = "PASSWORD1";
	public static final String NAME_TOKEN = "tokenValue";
	public static final String NAME_DESTINATION = "ANSWER_METADATA0";
	public static final String NAME_DELIVERY = "ANSWER_METADATA1";
	public static final String NAME_QN_ANS_1 = "answer2";
	public static final String NAME_QN_ANS_2 = "answer1";
	public static final String NAME_QN_ANS_3 = "answer";
	public static final String OPTION = "option";
	public static final String MAX_LENGTH = "maxLength";

	/** CSV value constants */
	public static final String EMPTY = "EMPTY";
	public static final String NULL = "NULL";
	public static final String VALID = "VALID";
	public static final String INVALID = "INVALID";
	public static final String EXPIRED = "EXPIRED";
	public static final String MAX_COUNT = "MAX_COUNT";

	/** Container constants */
	public static final String BANK_CONTAINER = "bank";
	public static final String INVESTMENT_CONTAINER = "investment";
	public static final String INSURANCE_CONTAINER = "insurance";
	public static final String CREDIT_CARD_CONTAINER = "creditCard";
	public static final String BILLS_CONTAINER = "bill";
	public static final String LOAN_CONTAINER = "loan";
	public static final String REWARD_CONTAINER = "reward";
	public static final String OTHER_ASSETS_CONTAINER = "otherAssets";
	public static final String OTHER_LIABILITIES_CONTAINER = "otherLiabilities";

	/** Status constants */
	public static final String ACTIVE_STATUS = "ACTIVE";
	public static final String INACTIVE_STATUS = "INACTIVE";
	public static final String CLOSED_STATUS = "CLOSED";

	public static final String MAX_LENGTH_LONG_ID = "12345678901234567891234456678891223455677899123234556645466545754643633464456436433";

	public static final String[] FIELD_VALUES = { "firstValue", "password", "thirdValue", "fourthValue", "fifthValue",
			"sixthValue", "seventhValue", "eigthValue", "ninthValue", "TenthValue", "eleventhValue", "twelvethValue",
			"123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134", "135", "136", "137",
			"138", "139", "140" };

	public static final String LOCALE_US = "en_US";
	public static final String LOCALE_UK = "en_UK";

	public static final String TOKEN_VALUE = "123456";
	public static final String OTP_PROVIDER = "524";
	public static final String USER_PASSWORD = "TEST@123";
	public static final String YSL_USER = "YSL";

	public static final String IAV_FULL_ACCOUNT_NUMBER = "ACCT_PROFILE.FULL_ACCT_NUMBER";
	public static final String IAV_BANK_TRANSFER_CODE = "ACCT_PROFILE.BANK_TRANSFER_CODE";
	public static final String IAV_HOLDER_NAME = "ACCT_PROFILE.HOLDER_NAME";
	public static final String DESTINATION = "destination";
	public static final String DELIVERY = "delivery";
	public static final String OTP = "OTP";
	public static final String LABEL = "label";
	public static final String LABEL1 = "Please enter phone / email to receive OTP";
	public static final String LABEL2 = "Please enter mode of communication (TEXT/ PHONE)";

	
	

	public static final String JSON_PATH_FREQUENCY = "";
	
	
	/*http://192.168.112.254:8580/ysl/fincheck/spending?accountId%40spending=11292654 
for API GA url endpoint has changed*/
  

	// File constants
	public final static String WORKING_DIRECTORY = System.getProperty("user.dir");
	public final static String FILEPATH = WORKING_DIRECTORY + "\\src\\main\\resources\\providerAccountId.properties";

	// Property file path for Skipping test cases or test classes
	public final static String JWT_SKIP_FILEPATH = WORKING_DIRECTORY
			+ "\\src\\main\\resources\\Jwt_skipList.properties";
	public final static String LEGACY_SKIP_FILEPATH = WORKING_DIRECTORY
			+ "\\src\\main\\resources\\Legacy_skipList.properties";

	// JWT Constants - need to update proper value
	public static final String JWT_AUTH_TOKEN = "v1/auth/token";

	// Masking constants
	public final static boolean isMaskingEnabled = true;;
	public final static String maskCharacter = null;
	public final static int maskLength = 0;

	public final static long THREAD_SLEEP = 15000;
	public final static long TEN_MINUTES_IN_NS = 600000000000l;
	public static final Long NEXTUPDATE = 0L;// 1475153420L;
	public static final Long NEXTUPDATE_FUTURE = 2520669426L;
	public static final String HOLDER = "holder";

	// FASTLINK CONSTANTS
	public static final long WAIT_TIME = 50;

	// MFA security questions
	public final static String FIRST_QUES = "What is the name of your state?";
	public final static String SECOND_QUES = "What is the name of your first school";

	// SLEEP_TIME_FOR_USER_SESSION_UPDATER
	public static final long WAIT_TIME_USER_SESSION_UPDATER = 900000;

	public static final String DEFAULT_PASSWORD = "Yodlee@1234";

	public static final String DAG_USERNAME = "dagUsername";
	public static final String DAG_PASSWORD = "dagPassword";
	public static final String SIMPLIFIED_FORM = "simplified";
	public static final String FIELD_ARRAY_FORM= "fieldarray";
	//public static final String LOGIN_FORM = "loginForm";
	public static final String PROVIDER_OBJECT_FORM= "providerobject";
	
		public static final String NEXT_UPDATE_SCHEDULED = "providerAccount[0].dataset[0].nextUpdateScheduled";
	public static final String IS_CACHE_REFRESH_SUPPORT = "is_cache_refresh_suprt";
	

	
	public static final int PKI_COBRAND_PARAM_KEY = 6166;
	
	public static final String GET_REPAYMENT_COUNT = "select count(REPAYMENT_PLAN_TYPE) from repayment_plan_type";
	public static final String GET_STATUS_COUNT = "select count(STATUS) from loan_status";
	public static final String GET_REPAYMENTPLAN_TYPE = "select REPAYMENT_PLAN_TYPE_ID from loan_ext where 1=2";
	public static final String GET_LOANSTATUS_ID = "select loan_status_id from loan_ext where 1=2";
	// ISO_TIME_FORMAT
	public final static String ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	
	// OB consent ProviderAccount(R-22538)
	public static final String JSON_PATH_CONSENT_ID = "consent[0].consentId";
	//public static final String JSON_PATH_AUTHORIZATION_URL = "authorizationUrl";
	public static final String JSON_PATH_AUTHORIZATION_URL = "consent[0].authorizationUrl";
	public static final String CONSENT_ID = "consentId";
	public static final String AUTHORIZATION_CODE = "authorizationCode";
	public static final String AUTH_RESPONSE = "authResponse";
	public static final String JSON_PATH_PROVIDER_CONSENT_ID = "providerAccount[0].consentId";
	public static final String MODELO_BANK_USERNAME = "mits";
	public static final String MODELO_BANK_PASSWORD = "mits";
	public static final String FORGEROCK_BANK_USERNAME = "yodemo";
	public static final String FORGEROCK_BANK_PASSWORD = "yoDemo@19";
	public static final String CONSENT = "consents";
	public static final String SCOPE_ID = "scopeId";
	public static final String SCOPE = "scope";
	public static final String PROVIDER_ACCOUNT_IDS_FILTER = "providerAccountIds";
	public static final String CONSENT_IDS = "consentIds";
	
	public static final String CONSEN = "consent";
	public static final CharSequence AUTHORIZATION_URL = "authorizationUrl";
	public static final String ACCOUNT =  "account";
	public static final String JSON_PATH_ACCOUNT_ID = "account[0].id";
	public static final String REAL_ESTATE_CONTAINER = "realEstate";
	
	public static final String REST_CONTENT_TYPE="application/x-www-form-urlencoded";
	
	
	public static final String APPLICATION_JSON_CONTENT_TYPE="application/json";
	public static final String BDF = "BDF";
	
	public static final String AUTH_JDBCSERVER = "AUTH_JDBCSERVER";
	public static final String AUTH_JDBCPORT = "AUTH_JDBCPORT";
	public static final String AUTH_JDBCID = "AUTH_JDBCID";
	public static final String AUTH_DBTYPE = "AUTH_DBTYPE";
	public static final String AUTH_ENV = "AUTH_ENV";
	
	//Encryption Decryption Related Constants.
	public static final String UTF8="UTF-8";
	public static final String MD5="MD5";
	public static final String AES="AES";
	
	public static final String OPEN_CURLY_BRACKET_SYMBOL="{";
	public static final String CLOSED_CURLY_BRACKET_SYMBOL="}";
	public static final String COMMA_SYMBOL=",";
	public static final String COLON_SYMBOL=":";
	public static final CharSequence OAUTH_USERNAME = "oauthiav.site19335.1";
	public static final CharSequence OAUTH_PASSWORD = "site19335.1";
	
	
	public static final String ENCRYPTED_SYMMETRIC_KEY = "encryptedSymmetricKey";
	public static final String ENCRYPTED_PAYLOAD = "encryptedPayload";
	public static final String IV = "iv";
	public static final String SYMMETRIC_KEY_ALGORITHM = "symmetricKeyAlgorithm";
	
	public static final String YCC_APP_URL = "YCC_APP_URL";
	public static final String YCC_APP_USERNAME = "YCC_APP_USERNAME";
	public static final String YCC_APP_PASSWORD = "YCC_APP_PASSWORD";
	
	public static final String SUBBRAND_PUBLISH_EMAIL_WAIT_TIME = "SUBBRAND_PUBLISH_EMAIL_WAIT_TIME";
	public static final String AUTHORIZATION_HEADER = "Authorization";
	public static final String FINAPPID_HEADER ="finappId";
	public static final String API_VERSION_HEADER="Api-Version";
	public static final String CONTENT_TYPE_HEADER="Content-Type";
	public static final String COBRAND_NAME_HEADER="Cobrand-Name";
	
	public static final String HAMMER="hammer";
	
	//SPS Constants
	public static final String SPS_PORT="SPS_PORT";
	public static final String SPS_URI="SPS_URI";
	
	public static final String CHROME="chrome";
	public static final String ECHO_CMD="echo ";
	
	public static final String DOUBLE_ARROW=" >> ./";
}

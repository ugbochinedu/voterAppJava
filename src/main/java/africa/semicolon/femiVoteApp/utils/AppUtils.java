package africa.semicolon.femiVoteApp.utils;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class AppUtils {
    private static int currentId;
    private static final Map<String, String> userInformationJoinTable = new HashMap<>();

    public static final int ZERO = BigInteger.ZERO.intValue();
    public static final int FIVE = BigInteger.valueOf(5).intValue();
    public static final int EIGHT = BigInteger.valueOf(8).intValue();

    public static String generateId(){
        currentId += 1;
        int generateId = currentId;
        return String.valueOf(generateId);
    }

    public static void linkUserToUserInformation(String userId, String userInformationId){
        userInformationJoinTable.put(userId,userInformationId);
    }

    public static String getUserInformationId(String userId){
        String userInformationId = userInformationJoinTable.get(userId);
        return userInformationId;
    }
}

package ge.unknown.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.time.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static ge.unknown.utils.constants.Constants.ControllerCodes.DEFAULT_SORT_BY;

public class GeneralUtil {


    public static String generateString(int length) {
        if (length < 5) length = 5;
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rng = new Random();
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = chars.charAt(rng.nextInt(chars.length()));
        }
        return String.valueOf(text);
    }

    public static String encodeMD5(String text) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(text.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {

        }
        return null;
    }


    /** DATE UTILS - START  **/

    public static int getDaysDifference(long t1, long t2) {
        if (t1 == t2) {
            return 0;
        }
        return (int) ((t2 - t1) / (1000 * 60 * 60 * 24));
    }

    public static int calculateAge(LocalDate birthDate) {
        if ((birthDate != null)) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }

    public static int localeBetween(LocalDate dateFrom, LocalDate dateTo){
        if ((dateFrom != null) && dateTo != null) {
            return Period.between(dateFrom, dateTo).getDays();
        } else {
            return 0;
        }
    }

    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /** DATE UTILS - END  **/

    public static String toString(InputStream is) {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        try{
            while ((length = is.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            return result.toString("UTF-8");

        } catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    /**
     * გვერდების ნუმერაციისთვის JpaRepository PageRequest,
     * SortBy Default : DEFAULT_SORT_BY
     * @param page
     * @param size
     * @param ascending
     * @param sortBy
     * @return
     */
    public static PageRequest paginate(int page, int size, boolean ascending, String... sortBy){

        boolean haveSortDirections = false;
        for (String v : sortBy) {
            if (v != null && !v.equals("")) {
                haveSortDirections = true;
                break;
            }
        }

        if(sortBy.length > 0 && haveSortDirections){
            return new PageRequest(
                page,
                size,
                (ascending) ? Sort.Direction.ASC : Sort.Direction.DESC,
                sortBy
            );
        } else{
            return new PageRequest(
                page,
                size,
                (ascending) ? Sort.Direction.ASC : Sort.Direction.DESC,
                DEFAULT_SORT_BY
            );
        }
    }

    public static RequestResponse RequestSuccess(){
        return new RequestResponse(true);
    }

    public static RequestResponse RequestSuccess(String message){
        return new RequestResponse(true, message);
    }

    public static RequestResponse RequestSuccess(String message, Integer code){
        return new RequestResponse(true, message, code);
    }

    public static RequestResponse RequestError(){
        return new RequestResponse(false);
    }

    public static RequestResponse RequestError(String message){
        return new RequestResponse(false, message);
    }

    public static RequestResponse RequestError(String message, Integer code){
        return new RequestResponse(false, message, code);
    }


    public static String mapToJsonString(Map<Integer, Double> hashMap)
    {
        JSONArray jsonArray = new JSONArray();
        for (Map.Entry<?, ?> entry : hashMap.entrySet()) {
            try {
                JSONObject json_obj = new JSONObject();
                Double val = (Double) entry.getValue();
                json_obj.put(String.valueOf(entry.getKey()), val);
                jsonArray.put(json_obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jsonArray.toString();
    }



    private static final String JS_PATTERN = "<script src=\"{name}\"></script>";

    public static void GenerateJS(Model model, String name){
        model.addAttribute("importJS", JS_PATTERN.replace("{name}", name));
    }

    public static void GenerateJS(Model model, List<String> names){
        StringBuilder stringBuilder = new StringBuilder();
        for(String s : names){
            stringBuilder.append(JS_PATTERN.replace("{name}", s));
        }
        model.addAttribute("importJS", stringBuilder.toString());
    }
}

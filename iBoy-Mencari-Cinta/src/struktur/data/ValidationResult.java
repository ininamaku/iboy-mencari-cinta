/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package struktur.data;

/**
 *
 * @author Fauzan
 */
public class ValidationResult {

    public final static int VALIDATION_OK = 0;
    public final static int INVALID_GIRL = 1;
    public final static int INVALID_GIFT = 2;
    public IBoy iboy;
    public int d;
    public int h;
    public int type;

    public static ValidationResult CreateValidationResult(int type, IBoy iboyClone, int d, int h) {
        ValidationResult val = new ValidationResult();
        val.type = type;
        val.iboy = iboyClone;
        val.d = d;
        val.h = h;
        return val;
    }
}

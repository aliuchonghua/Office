package com.westos.Information.bean;

/**表单验证
 * @author liuchonghua
 */
public class Validator {
    private Boolean valid;

    @Override
    public String toString() {
        return "Validator{" +
                "valid=" + valid +
                '}';
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Validator(Boolean valid) {
        this.valid = valid;
    }
}

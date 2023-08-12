/**
 * ClassName:      Son
 * Description:    Description
 * Author:         zh
 * CreateDate:     2021/9/2 2:53 PM
 * UpdateUser:     zh
 * UpdateDate:     2021/9/2 2:53 PM
 * UpdateRemark:   Modify the description
 */
package com.kot.test.mockk;

public class Son {
    public int publicResult() {
        return privateResult();
    }

    private int privateResult() {
        return 5;
    }
}

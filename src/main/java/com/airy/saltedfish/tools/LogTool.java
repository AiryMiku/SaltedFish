package com.airy.saltedfish.tools;

/**
 * Created by Airy on 2017/11/14
 */


public class LogTool {

    private static LogTool uniquelogger;

    private LogTool(){}

    public static LogTool getInstance() {
        if (uniquelogger == null) {
            uniquelogger = new LogTool();
        }
        return uniquelogger;
    }



}

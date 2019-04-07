package com.corelogic.condosafe.staging.cli.runners;

import com.corelogic.condosafe.staging.common.constants.IOConstants;
import com.corelogic.condosafe.staging.common.io.ExcelFileUtil;
import com.corelogic.condosafe.staging.managers.LandingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Component
public class FileLoaderRunner implements ApplicationRunner {

    @Autowired
    private LandingManager landingManager;

    @Override
    public void run(ApplicationArguments args) {
        boolean containFileStoragePath = args.containsOption(IOConstants.CLI_ARG_FILES_PATH);
        if (containFileStoragePath) {
            List<String> argsPassed = args.getNonOptionArgs();
            argsPassed.stream().forEach(
                    s -> {
                        File file = Paths.get(s).toFile();
                        if (file.isDirectory()) {
                            String[] files = file.list();
                            String path = file.getAbsolutePath();
                            String separator = "\\";
                            Arrays.stream(files).forEach(f -> {
                                landingManager.process(path + separator + f);
                            });
                        }
                    }
            );
        }
    }
}
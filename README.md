# bisq-common

## Build

    ./gradlew build

## Import into IDEA

_The following instructions have been tested in IDEA 2017.3_

### Configure IDEA properties

Go to `Help->Edit Custom Properties...` and add the following line:

    idea.max.intellisense.filesize=12500

Now close and restart IDEA. This ensures that IDEA will be able to handle Bisq's very large generated `PB.java` Protobuf sources. Without changing this setting, you will get compilation errors in IDEA wherever these generated types are used.

### Import the project

Go to `File->Open...` and choose this project's `build.gradle` file. When prompted whether to overwrite the existing `.idea` directory, choose "Yes".

In the `Project` tool window, right click on the `.idea` folder, select `Git->Revert...` and click OK in the dialog that appears. Doing this restores source-controlled `.idea` configuration files that get overwritten during project import.

You should now be able to build the project without errors using `Build->Build Project`.

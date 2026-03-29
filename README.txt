-------------------------------------------
TRAPIST-1 Mod for Minecraft 1.12.2
-------------------------------------------
This is a mod for Minecraft 1.12.2 based on the Minecraft Forge framework.

Installation Instructions:
==========================

For Eclipse:
1. Run the following command: "gradlew genEclipseRuns" (./gradlew genEclipseRuns if you are on Mac/Linux)
2. Open Eclipse, Import > Existing Gradle Project > Select Folder 
   or run "gradlew eclipse" to generate the project.
3. Open Project > Run/Debug Settings > Edit runClient and runServer > Environment
4. Edit MOD_CLASSES to show [trapistsone]%%[Path]; 2 times rather then the generated 4.

For IntelliJ IDEA:
1. Open IDEA, and import project.
2. Select your build.gradle file and have it import.
3. Run the following command: "gradlew genIntellijRuns" (./gradlew genIntellijRuns if you are on Mac/Linux)
4. Refresh the Gradle Project in IDEA if required.

If you encounter any issues with missing libraries or other problems:
- Run "gradlew --refresh-dependencies" to refresh the local cache.
- Run "gradlew clean" to reset everything (this does not affect your code).
- Then start the process again.

For additional help:
- Refer to #ForgeGradle on EsperNet for more information about the gradle environment.
- Visit the Forge Project Discord: discord.gg/UvedJ9m

Building the Mod:
=================
To build the mod, run the following command:
- Windows: "gradlew build"
- Mac/Linux: "./gradlew build"

The resulting jar file will be located in the "build/libs" directory.

For more information about Minecraft Forge and mod development, refer to the Forge Forums:
http://www.minecraftforge.net/forum/index.php/topic,14048.0.html

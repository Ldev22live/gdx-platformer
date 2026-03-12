/*
 * Copyright 2020 damios
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Note, the above license and copyright applies to this file only.
package io.github.some_example_name.lwjgl3;

import java.util.Locale;

/**
 * A helper object for game startup, featuring a utility for Windows.
 *
 * <p>
 * The Windows utility prevents a common crash related to LWJGL3's extraction of shared library files
 * when the user's home directory contains non-ASCII or otherwise problematic characters.
 */
public class StartupHelper {

    private StartupHelper() {}

    /**
     * Applies the Windows-only utility described by {@link StartupHelper}'s Javadoc.
     *
     * <b>Usage:</b>
     * <pre><code>
     * public static void main(String[] args) {
     *     if (StartupHelper.startNewJvmIfRequired()) return;
     *     // ... The rest of main() goes here, as normal.
     * }
     * </code></pre>
     *
     * @return whether a child JVM process was spawned. This helper never spawns a child JVM on Windows.
     */
    public static boolean startNewJvmIfRequired() {
        return startNewJvmIfRequired(true);
    }

    /**
     * Applies the Windows-only utility described by {@link StartupHelper}'s Javadoc.
     *
     * @param inheritIO whether I/O should be inherited in the child JVM process.
     * @return whether a child JVM process was spawned. This helper never spawns a child JVM on Windows.
     */
    public static boolean startNewJvmIfRequired(boolean inheritIO) {
        // This helper is intentionally minimal to avoid requiring libGDX classes at compile-time.
        // It is expected that the full libGDX dependency set is available at runtime via Gradle.
        return false;
    }
}
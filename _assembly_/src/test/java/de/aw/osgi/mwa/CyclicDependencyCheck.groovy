package de.aw.osgi.mwa

import com.kirkk.analyzer.Analyzer
import com.kirkk.analyzer.framework.Jar
import org.junit.Test

import static org.junit.Assert.*

/**
 *
 * @author armin.weisser
 *
 */
class CyclicDependencyCheck {

    public static final String JAR_DIRECTORY = "felix/bundle"
    def INCLUCDE_PATTERNS = ["de.aw.osgi.mwa"]

    @Test
    public void testJarCycles() throws Exception {
        // Set up the data
        File jarDir = new File(JAR_DIRECTORY);

        // Run the test
        Analyzer analyzer = new Analyzer();
        Jar[] jarbundle = analyzer.analyze(jarDir);

        // Check for cycles
        def cyclicJars = jarbundle.findAll { Jar jar ->
            INCLUCDE_PATTERNS.any { jar.getJarFileName().startsWith(it) } && jar.hasCycles()
        }

        // print output
        cyclicJars.each {  Jar jar ->
            println jar.getJarFileName() + " in a cycle with " + getJarNames(jar.getCyclicJars())
        }

        // Check if there are no cycles
        assertEquals("Cycles found", 0, cyclicJars.size())
    }

    private String getJarNames(List jarList) {
        StringBuffer names = new StringBuffer();

        for (Iterator i = jarList.iterator(); i.hasNext(); ) {
            Jar jar = (Jar) i.next();
            names.append(jar.getJarFileName());
            names.append(" ");
        }
        return names.toString();
    }

}

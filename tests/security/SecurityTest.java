package security;

import checkers.inference.test.CFInferenceTest;
import security.solver.SecuritySolverEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.framework.test.TestUtilities;
import org.checkerframework.javacutil.Pair;
import org.junit.runners.Parameterized.Parameters;

public class SecurityTest extends CFInferenceTest {

    public SecurityTest(File testFile) {
        super(
                testFile,
                security.SecurityChecker.class,
                "ontology",
                "-Anomsgtext",
                "-d",
                "tests/build/outputdir");
    }

    @Override
    public boolean useHacks() {
        return true;
    }

    @Override
    public Pair<String, List<String>> getSolverNameAndOptions() {
        final String solverName = SecuritySolverEngine.class.getCanonicalName();
        List<String> solverOptions = new ArrayList<>();
        // solverOptions.add("solver=Z3");
        return Pair.of(solverName, solverOptions);
    }

    @Parameters
    public static List<File> getTestFiles() {
        List<File> testfiles = new ArrayList<>();
        testfiles.addAll(TestUtilities.getJavaFilesAsArgumentList(new File("testing")));
        return testfiles;
    }
}

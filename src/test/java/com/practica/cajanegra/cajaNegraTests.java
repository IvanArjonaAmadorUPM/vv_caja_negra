package com.practica.cajanegra;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

@SelectPackages({"com.practica.cajanegra.addTests"
                ,"com.practica.cajanegra.removeTests"
                ,"com.practica.cajanegra.posTests"
                ,"com.practica.cajanegra.infoTests"})

@Suite

public class cajaNegraTests {
}

// LibraryApplication.java
package com.library;

import com.library.controllers.LibraryController;

public class LibraryApplication {
    public static void main(String[] args) {
        LibraryController controller = new LibraryController();
        controller.run();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.tc.cat.the.util;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * The Visitor class is an abstract class of SimpleFileVisitor and can be used to do so.
 * @author Christian Trostmann
 * @since  8.0
 * @version 1.0
 * @see java.nio.file.SimpleFileVisitor
 */
public class Visitor extends SimpleFileVisitor<Path> {
	private final Path fromPath;
	private final Path toPath;
	private final StandardCopyOption copyOption = StandardCopyOption.REPLACE_EXISTING;
        /**
         * The Visitor function is used to create the Visitor class and is required to use all functions.
         * @param fromPath Specifies the source from where the files and folders are copied.
         * @param toPath Specifies the destination where the files and folders are copied.
         * 
         */
	public Visitor(Path fromPath, Path toPath) {
		this.fromPath = fromPath;
		this.toPath = toPath;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		Path targetPath = toPath.resolve(fromPath.relativize(dir));
		if (!Files.exists(targetPath)) {
			Files.createDirectory(targetPath);
		}
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		System.out.println(file);
		Files.copy(file, toPath.resolve(fromPath.relativize(file)), copyOption);
		return FileVisitResult.CONTINUE;
	}
}



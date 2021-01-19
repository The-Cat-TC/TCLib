package de.tc.cat.the.util;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Creates a {@code FileSystemView} which can be used to integrate archives or other files.
 * @author Christian Trostmann
 * @version 1.0
 * @since 15
 * @see javax.swing.filechooser.FileSystemView
 */
public class JFileSystemView extends FileSystemView {
    FileSystem fileSystem;
    public JFileSystemView (FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    /**
     * Creates a {@link FileSystemView} based on a {@link FileSystem}.
     * @param file gives the file to be linked to.
     * @throws IOException throws an exception if there is an error when creating the {@link FileSystem}.
     */
    public JFileSystemView (File file) throws IOException {
        fileSystem = FileSystems.newFileSystem(file.toPath());
    }

    /**
     * Creates a {@link FileSystemView} based on a {@link FileSystem}.
     * @param path gives the path to be linked to.
     * @throws IOException throws an exception if there is an error when creating the {@link FileSystem}.
     */
    public JFileSystemView (Path path) throws IOException {
        fileSystem = FileSystems.newFileSystem(path);
    }

    /**
     * Creates a {@link FileSystemView} based on a {@link FileSystem}.
     */
    public JFileSystemView() {
        fileSystem = FileSystems.getDefault();
    }

    /**
     * Retrieves the current {@link FileSystem}.
     * @return returns the current FileSystem.
     */
    public FileSystem getFileSystem() {
        return fileSystem;
    }

    /**
     * Sets a new {@link FileSystem}.
     * @param fileSystem indicates the new FileSystem.
     */
    public void setFileSystem(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    /**
     * Retrieves the root directory.
     * @return returns the root directory as {@link Path}.
     */
    public Path getRoot() {
        return fileSystem.getRootDirectories().iterator().next();
    }

    /**
     * Returns the root directorys.
     * @return Returns the root directorys as {@link Iterable <Path>}.
     */
    public Iterable<Path> getRootDirectorys() {
        return fileSystem.getRootDirectories();
    }

    /**
     * Determines if the given file is a root in the navigable tree(s).
     * Examples: Windows 98 has one root, the Desktop folder. DOS has one root
     * per drive letter, {@codeC:\}, {@codeD:\}, etc. Unix has one root,
     * the {@code"/"} directory.
     * <p>
     * The default implementation gets information from the {@codeShellFolder} class.
     *
     * @param f a {@codeFile} object representing a directory
     * @return {@codetrue} if {@codef} is a root in the navigable tree.
     * @see #isFileSystemRoot
     */
    @Override
    public boolean isRoot(File f) {
        return true;
    }

    /**
     * Is dir the root of a tree in the file system, such as a drive
     * or partition. Example: Returns true for "C:\" on Windows 98.
     *
     * @param dir a {@codeFile} object representing a directory
     * @return {@codetrue} if {@codef} is a root of a filesystem
     * @see #isRoot
     * @since 1.4
     */
    @Override
    public boolean isFileSystemRoot(File dir) {
        return true;
    }

    /**
     * Returns all root partitions on this system. For example, on
     * Windows, this would be the "Desktop" folder, while on DOS this
     * would be the A: through Z: drives.
     *
     * @return an array of {@code File} objects representing all root partitions
     * on this system
     */
    @Override
    public File[] getRoots() {
        return new File[] {new File(fileSystem.getRootDirectories().iterator().next().toString())};
    }

    /**
     * Returns the home directory.
     *
     * @return the home directory
     */
    @Override
    public File getHomeDirectory() {
        return getRoot().toFile();
    }

    /**
     * Return the user's default starting directory for the file chooser.
     *
     * @return a {@codeFile} object representing the default
     * starting folder
     * @since 1.4
     */
    @Override
    public File getDefaultDirectory() {
        return getRoot().toFile();
    }

    /**
     * Returns the parent directory of {@codedir}.
     *
     * @param dir the {@codeFile} being queried
     * @return the parent directory of {@codedir}, or
     * {@codenull} if {@codedir} is {@codenull}
     */
    @Override
    public File getParentDirectory(File dir) {
        return super.getParentDirectory(dir);
    }

    /**
     * Creates a new folder with a default folder name.
     *
     * @param containingDir a {@code File} object denoting directory to contain the new folder
     * @return a {@code File} object denoting the newly created folder
     * @throws IOException if new folder could not be created
     */
    @Override
    public File createNewFolder(File containingDir) throws IOException {
        return containingDir;
    }
}

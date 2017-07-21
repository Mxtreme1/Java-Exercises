package filesystem;


import java.util.List;
import java.util.regex.Pattern;

/**
 * Interface for an immutable filesystem tree.
 */
public interface FSTree {

    /**
     * Return the total size of the tree, i.e. the sum of the sizes of all its
     * files.
     */
    int getSize();

    /**
     * Return a list of TextFiles (i.e. name and content) contained in this
     * FSTree that match the Regexp "matchName".
     */
    List<Document> find(Pattern matchName);

    /**
     * Return a new FSTree from this FSTree with the name and content of "file"
     * inserted at "path". This FSTree is not modified. Missing "path" elements
     * are created as Directories. If the "path" cannot be created, an
     * IllegalArgumentException is thrown.
     *
     * @param path     The path as a list of Strings where the file should be
     *                 created.
     * @param document The name and content of the file to be created, as a
     *                 Document.
     * @return The new FSTree.
     */
    FSTree createFile(List<String> path, Document document);

}

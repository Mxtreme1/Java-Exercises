package filesystem;

public class Document {
    private final String name;
    private final String content;

    public Document(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        if (name != null ? !name.equals(document.name) : document.name != null)
            return false;
        return content != null ? content.equals(document.content) :
               document.content == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Document{" +
               "name='" + name + '\'' +
               ", content='" + content + '\'' +
               '}';
    }
}

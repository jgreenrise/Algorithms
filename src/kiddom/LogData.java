package kiddom;

public class LogData {
    private long timestamp;
    private String userId;
    private String pageId;
    private String pageType;
    private String action;

    // Constructor
    public LogData(long timestamp, String userId, String pageId, String pageType, String action) {
        this.timestamp = timestamp;
        this.userId = userId;
        this.pageId = pageId;
        this.pageType = pageType;
        this.action = action;
    }

    // Getters
    public long getTimestamp() {
        return timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public String getPageId() {
        return pageId;
    }

    public String getPageType() {
        return pageType;
    }

    public String getAction() {
        return action;
    }

    // Override toString for easy printing
    @Override
    public String toString() {
        return timestamp +
                "," + userId + '\'' +
                "," + pageId + '\'' +
                "," + pageType + '\'' +
                "," + action + '\n';
    }
}



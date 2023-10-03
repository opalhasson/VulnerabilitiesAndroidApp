package com.example.myappstady;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class NVD {
    @JsonProperty("vulnerabilities")
    private List<CVEEntry> vulnerabilities;

    @JsonProperty("resultsPerPage")
    private int resultsPerPage;

    @JsonProperty("startIndex")
    private int startIndex;

    @JsonProperty("totalResults")
    private int totalResults;

    @JsonProperty("format")
    private String format;

    @JsonProperty("version")
    private String version;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("id")
    private String id;

    public List<CVEEntry> getVulnerabilities() {
        return vulnerabilities;
    }

    public void setVulnerabilities(List<CVEEntry> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    public int getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(int resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static class CVEEntry {
        @JsonProperty("cve")
        private CVE cve;

        public CVE getCve() {
            return cve;
        }

        public void setCve(CVE cve) {
            this.cve = cve;
        }
    }
}

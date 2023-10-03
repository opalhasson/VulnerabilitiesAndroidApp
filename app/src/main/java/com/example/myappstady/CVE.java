package com.example.myappstady;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;



public class CVE {
    @JsonProperty("id")
    private String id;

    @JsonProperty("sourceIdentifier")
    private String sourceIdentifier;

    @JsonProperty("published")
    private String published;

    @JsonProperty("lastModified")
    private String lastModified;

    @JsonProperty("vulnStatus")
    private String vulnStatus;

    @JsonProperty("descriptions")
    private List<Description> descriptions;

    @JsonProperty("metrics")
    private Metrics metrics;

    @JsonProperty("weaknesses")
    private List<Weakness> weaknesses;

    @JsonProperty("configurations")
    private List<Configuration> configurations;

    @JsonProperty("references")
    private List<Reference> references;

    @JsonProperty("evaluatorSolution")
    private String evaluatorSolution;

    @JsonProperty("evaluatorImpact")
    private String evaluatorImpact;

    @JsonProperty("vendorComments")
    private List<VendorComment> vendorComments;

    @JsonProperty("evaluatorComment")
    private String evaluatorComment;

    public String getId() {
        return id;
    }

    public static class VendorComment {
        @JsonProperty("organization")
        private String organization;

        @JsonProperty("comment")
        private String comment;

        @JsonProperty("lastModified")
        private String lastModified;
    }

    public static class Description {
        @JsonProperty("lang")
        private String lang;

        @JsonProperty("value")
        private String value;
    }

    public static class Metrics {
        @JsonProperty("cvssMetricV2")
        private List<CVSSMetricV2> cvssMetricsV2;

        @JsonProperty("cvssMetricV31")
        private List<CVSSMetricV2> cvssMetricV31;

        @JsonProperty("cvssMetricV30")
        private List<CVSSMetricV2> cvssMetricV30;

        public static class CVSSMetricV2 {
            @JsonProperty("source")
            private String source;

            @JsonProperty("type")
            private String type;

            @JsonProperty("cvssData")
            private CVSSData cvssData;

            @JsonProperty("baseSeverity")
            private String baseSeverity;

            @JsonProperty("exploitabilityScore")
            private String exploitabilityScore;

            @JsonProperty("impactScore")
            private String impactScore;

            @JsonProperty("acInsufInfo")
            private String acInsufInfo;

            @JsonProperty("obtainAllPrivilege")
            private String obtainAllPrivilege;

            @JsonProperty("obtainUserPrivilege")
            private String obtainUserPrivilege;

            @JsonProperty("obtainOtherPrivilege")
            private String obtainOtherPrivilege;

            @JsonProperty("userInteractionRequired")
            private String userInteractionRequired;

            public static class CVSSData {
                @JsonProperty("version")
                private String version;

                @JsonProperty("vectorString")
                private String vectorString;

                @JsonProperty("accessVector")
                private String accessVector;

                @JsonProperty("accessComplexity")
                private String accessComplexity;

                @JsonProperty("authentication")
                private String authentication;

                @JsonProperty("confidentialityImpact")
                private String confidentialityImpact;

                @JsonProperty("integrityImpact")
                private String integrityImpact;

                @JsonProperty("availabilityImpact")
                private String availabilityImpact;

                @JsonProperty("baseScore")
                private double baseScore;

                @JsonProperty("attackVector")
                private String attackVector;

                @JsonProperty("attackComplexity")
                private String attackComplexity;

                @JsonProperty("privilegesRequired")
                private String privilegesRequired;

                @JsonProperty("userInteraction")
                private String userInteraction;

                @JsonProperty("scope")
                private String scope;

                @JsonProperty("baseSeverity")
                private String baseSeverity;
            }
        }
    }

    public static class Weakness {
        @JsonProperty("source")
        private String source;

        @JsonProperty("type")
        private String type;

        @JsonProperty("description")
        private List<Description> description;
    }

    public static class Configuration {
        @JsonProperty("nodes")
        private List<Node> nodes;

        @JsonProperty("operator")
        private String operator;

        public static class Node {
            @JsonProperty("operator")
            private String operator;

            @JsonProperty("negate")
            private boolean negate;

            @JsonProperty("cpeMatch")
            private List<CPEMatch> cpeMatch;

            public static class CPEMatch {
                @JsonProperty("vulnerable")
                private boolean vulnerable;

                @JsonProperty("criteria")
                private String criteria;

                @JsonProperty("matchCriteriaId")
                private String matchCriteriaId;

                @JsonProperty("versionEndIncluding")
                private String versionEndIncluding;

                @JsonProperty("versionEndExcluding")
                private String versionEndExcluding;

                @JsonProperty("versionStartIncluding")
                private String versionStartIncluding;
            }
        }
    }

    public static class Reference {
        @JsonProperty("url")
        private String url;

        @JsonProperty("source")
        private String source;

        @JsonProperty("tags")
        private List<Tag> tags;

        public static class Tag {
            @JsonProperty("value")
            private String value;

            public Tag() {}

            public Tag(String value) {
                this.value = value;
            }
        }
    }
}


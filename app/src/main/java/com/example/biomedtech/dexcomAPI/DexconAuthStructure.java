package com.example.biomedtech.dexcomAPI;

public class DexconAuthStructure {
        private String accessToken;
        private String refreshToken;
        private long expiresIn;
        private String tokenType;

        public String getAccessToken() { return accessToken; }
        public void setAccessToken(String value) { this.accessToken = value; }

        public String getRefreshToken() { return refreshToken; }
        public void setRefreshToken(String value) { this.refreshToken = value; }

        public long getExpiresIn() { return expiresIn; }
        public void setExpiresIn(long value) { this.expiresIn = value; }

        public String getTokenType() { return tokenType; }
        public void setTokenType(String value) { this.tokenType = value; }
}
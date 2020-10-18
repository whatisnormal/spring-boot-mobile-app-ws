    /*
     * The copyright of this file belongs to Feedzai. The file cannot be
     * reproduced in whole or in part, stored in a retrieval system,
     * transmitted in any form, or by any means electronic, mechanical,
     * photocopying, or otherwise, without the prior permission of the owner.
     *
     * (c) 2018 Feedzai, Strictly Confidential
     */

    package com.whatisnormal.app.ws.ui.model.request;

    /**
     * FIXME
     *
     * @author José Fernandes (jose.fernandes@feedzai.com)
     * @since @@@feedzai.next.release@@@
     */

    public class UserDetailsRequestModel {
        private String userId;
        private String firstName;
        private String lastName;
        private String email;
        private String password;

        public String getUserId() {
            return this.userId;
        }

        public void setUserId(final String userId) {
            this.userId = userId;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public void setFirstName(final String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public void setLastName(final String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return this.email;
        }

        public void setEmail(final String email) {
            this.email = email;
        }

        public String getPassword() {
            return this.password;
        }

        public void setPassword(final String password) {
            this.password = password;
        }
    }

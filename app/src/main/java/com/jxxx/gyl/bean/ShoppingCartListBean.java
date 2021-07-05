package com.jxxx.gyl.bean;

import java.util.List;

public class ShoppingCartListBean {

    /**
     * totalAmount : 33.9
     * itemList : [{"id":5,"cartSpuDTO":{"id":"1","spuName":"牛筒骨  解冻品","spuSupplyType":2,"suppliersName":"三都港","iconUrl":"https://tse1-mm.cn.bing.net/th/id/OIP-C.NmdXHefRPYfMk61ACChXCgHaE7?w=259&h=180&c=7&o=5&pid=1.7","cartSkuDTO":{"id":"1","spuId":"1","skuName":"3斤","skuUnit":"10/斤","skuNum":1,"skuPriceDTO":{"skuPrice":10.5}}},"checked":1,"currentStatus":1,"groupKey":"三都港","tips":"","extension":""},{"id":6,"cartSpuDTO":{"id":"3","spuName":"毛肚","spuSupplyType":2,"suppliersName":"三都港","iconUrl":"https://tse1-mm.cn.bing.net/th/id/OIP-C.NmdXHefRPYfMk61ACChXCgHaE7?w=259&h=180&c=7&o=5&pid=1.7","cartSkuDTO":{"id":"6","spuId":"3","skuName":"500g","skuUnit":"10/300g","skuNum":1,"skuPriceDTO":{"skuPrice":1}}},"checked":1,"currentStatus":1,"groupKey":"三都港","tips":"","extension":""},{"id":7,"cartSpuDTO":{"id":"2","spuName":"牛百叶 水发","spuSupplyType":1,"suppliersName":"三都港","iconUrl":"https://tse1-mm.cn.bing.net/th/id/OIP-C.NmdXHefRPYfMk61ACChXCgHaE7?w=259&h=180&c=7&o=5&pid=1.7","cartSkuDTO":{"id":"3","spuId":"2","skuName":"小袋","skuUnit":"10/件","skuNum":2,"skuPriceDTO":{"skuPrice":11.2}}},"checked":1,"currentStatus":1,"groupKey":"三都港","tips":"","extension":""}]
     */

    private String totalAmount;
    private List<ItemListBean> itemList;

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<ItemListBean> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemListBean> itemList) {
        this.itemList = itemList;
    }

    public static class ItemListBean {
        /**
         * id : 5
         * cartSpuDTO : {"id":"1","spuName":"牛筒骨  解冻品","spuSupplyType":2,"suppliersName":"三都港","iconUrl":"https://tse1-mm.cn.bing.net/th/id/OIP-C.NmdXHefRPYfMk61ACChXCgHaE7?w=259&h=180&c=7&o=5&pid=1.7","cartSkuDTO":{"id":"1","spuId":"1","skuName":"3斤","skuUnit":"10/斤","skuNum":1,"skuPriceDTO":{"skuPrice":10.5}}}
         * checked : 1
         * currentStatus : 1
         * groupKey : 三都港
         * tips :
         * extension :
         */

        private String id;
        private CartSpuDTOBean cartSpuDTO;
        private String checked;
        private String currentStatus;
        private String groupKey;
        private String tips;
        private String extension;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public CartSpuDTOBean getCartSpuDTO() {
            return cartSpuDTO;
        }

        public void setCartSpuDTO(CartSpuDTOBean cartSpuDTO) {
            this.cartSpuDTO = cartSpuDTO;
        }

        public String getChecked() {
            return checked;
        }

        public void setChecked(String checked) {
            this.checked = checked;
        }

        public String getCurrentStatus() {
            return currentStatus;
        }

        public void setCurrentStatus(String currentStatus) {
            this.currentStatus = currentStatus;
        }

        public String getGroupKey() {
            return groupKey;
        }

        public void setGroupKey(String groupKey) {
            this.groupKey = groupKey;
        }

        public String getTips() {
            return tips;
        }

        public void setTips(String tips) {
            this.tips = tips;
        }

        public String getExtension() {
            return extension;
        }

        public void setExtension(String extension) {
            this.extension = extension;
        }

        public static class CartSpuDTOBean {
            /**
             * id : 1
             * spuName : 牛筒骨  解冻品
             * spuSupplyType : 2
             * suppliersName : 三都港
             * iconUrl : https://tse1-mm.cn.bing.net/th/id/OIP-C.NmdXHefRPYfMk61ACChXCgHaE7?w=259&h=180&c=7&o=5&pid=1.7
             * cartSkuDTO : {"id":"1","spuId":"1","skuName":"3斤","skuUnit":"10/斤","skuNum":1,"skuPriceDTO":{"skuPrice":10.5}}
             */

            private String id;
            private String spuName;
            private String spuSupplyType;
            private String suppliersName;
            private String iconUrl;
            private CartSkuDTOBean cartSkuDTO;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSpuName() {
                return spuName;
            }

            public void setSpuName(String spuName) {
                this.spuName = spuName;
            }

            public String getSpuSupplyType() {
                return spuSupplyType;
            }

            public void setSpuSupplyType(String spuSupplyType) {
                this.spuSupplyType = spuSupplyType;
            }

            public String getSuppliersName() {
                return suppliersName;
            }

            public void setSuppliersName(String suppliersName) {
                this.suppliersName = suppliersName;
            }

            public String getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
            }

            public CartSkuDTOBean getCartSkuDTO() {
                return cartSkuDTO;
            }

            public void setCartSkuDTO(CartSkuDTOBean cartSkuDTO) {
                this.cartSkuDTO = cartSkuDTO;
            }

            public static class CartSkuDTOBean {
                /**
                 * id : 1
                 * spuId : 1
                 * skuName : 3斤
                 * skuUnit : 10/斤
                 * skuNum : 1
                 * skuPriceDTO : {"skuPrice":10.5}
                 */

                private String id;
                private String spuId;
                private String skuName;
                private String skuUnit;
                private String skuNum;
                private SkuPriceDTOBean skuPriceDTO;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getSpuId() {
                    return spuId;
                }

                public void setSpuId(String spuId) {
                    this.spuId = spuId;
                }

                public String getSkuName() {
                    return skuName;
                }

                public void setSkuName(String skuName) {
                    this.skuName = skuName;
                }

                public String getSkuUnit() {
                    return skuUnit;
                }

                public void setSkuUnit(String skuUnit) {
                    this.skuUnit = skuUnit;
                }

                public String getSkuNum() {
                    return skuNum;
                }

                public void setSkuNum(String skuNum) {
                    this.skuNum = skuNum;
                }

                public SkuPriceDTOBean getSkuPriceDTO() {
                    return skuPriceDTO;
                }

                public void setSkuPriceDTO(SkuPriceDTOBean skuPriceDTO) {
                    this.skuPriceDTO = skuPriceDTO;
                }

                public static class SkuPriceDTOBean {
                    /**
                     * skuPrice : 10.5
                     */

                    private String skuPrice;

                    public String getSkuPrice() {
                        return skuPrice;
                    }

                    public void setSkuPrice(String skuPrice) {
                        this.skuPrice = skuPrice;
                    }
                }
            }
        }
    }
}

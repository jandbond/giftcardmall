
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderOrderManager from "./components/listers/OrderOrderCards"
import OrderOrderDetail from "./components/listers/OrderOrderDetail"

import PaymentPaymentManager from "./components/listers/PaymentPaymentCards"
import PaymentPaymentDetail from "./components/listers/PaymentPaymentDetail"

import GiftcardGiftCardManager from "./components/listers/GiftcardGiftCardCards"
import GiftcardGiftCardDetail from "./components/listers/GiftcardGiftCardDetail"

import CustomerCustomerManager from "./components/listers/CustomerCustomerCards"
import CustomerCustomerDetail from "./components/listers/CustomerCustomerDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders/orders',
                name: 'OrderOrderManager',
                component: OrderOrderManager
            },
            {
                path: '/orders/orders/:id',
                name: 'OrderOrderDetail',
                component: OrderOrderDetail
            },

            {
                path: '/payments/payments',
                name: 'PaymentPaymentManager',
                component: PaymentPaymentManager
            },
            {
                path: '/payments/payments/:id',
                name: 'PaymentPaymentDetail',
                component: PaymentPaymentDetail
            },

            {
                path: '/giftcards/giftCards',
                name: 'GiftcardGiftCardManager',
                component: GiftcardGiftCardManager
            },
            {
                path: '/giftcards/giftCards/:id',
                name: 'GiftcardGiftCardDetail',
                component: GiftcardGiftCardDetail
            },

            {
                path: '/customers/customers',
                name: 'CustomerCustomerManager',
                component: CustomerCustomerManager
            },
            {
                path: '/customers/customers/:id',
                name: 'CustomerCustomerDetail',
                component: CustomerCustomerDetail
            },




    ]
})

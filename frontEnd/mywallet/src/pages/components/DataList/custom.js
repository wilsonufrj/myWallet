export default class ProductService {

    getProductsSmall() {
		return fetch('data.json').then(res => res.json()).then(d => d.data);
	}

	getProducts() {
		return fetch('./data.json').then(res => res.json()).then(d => d.data);
    }

    getProductsWithOrdersSmall() {
		return fetch('data/products-orders-small.json').then(res => res.json()).then(d => d.data);
	}
}
 
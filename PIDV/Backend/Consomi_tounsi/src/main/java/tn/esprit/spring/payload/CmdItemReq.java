package tn.esprit.spring.payload;

public class CmdItemReq {
		private long idProd;
		private int quantity;
		public CmdItemReq() {
			super();
			// TODO Auto-generated constructor stub
		}
		public long getIdProd() {
			return idProd;
		}
		public void setIdProd(long idProd) {
			this.idProd = idProd;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public CmdItemReq(int idProd, int quantity) {
			super();
			this.idProd = idProd;
			this.quantity = quantity;
		}
}

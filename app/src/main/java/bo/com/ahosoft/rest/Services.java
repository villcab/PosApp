/*  File Version: 1.0
 *	Copyright, KENJI KAWAIDA, Hajimesoft.com
 *
 *	All rights reserved.
 *
 *	Redistribution and use in source and binary forms, with or without modification, are 
 *	permitted provided that the following conditions are met:
 *
 *	Redistributions of source code must retain the above copyright notice which includes the
 *	name(s) of the copyright holders. It must also retain this list of conditions and the 
 *	following disclaimer. 
 *
 *	Redistributions in binary form must reproduce the above copyright notice, this list 
 *	of conditions and the following disclaimer in the documentation and/or other materials 
 *	provided with the distribution. 
 *
 *	Neither the name of KENJI KAWAIDA, or Hajimesot.com nor the names of its contributors 
 *	may be used to endorse or promote products derived from this software without specific 
 *	prior written permission.
 *
 *	THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
 *	ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 *	WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 *	IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
 *	INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
 *	NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
 *	PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 *	WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 *	ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY 
 *	OF SUCH DAMAGE. 
 */
package bo.com.ahosoft.rest;

@SuppressWarnings("unused")
public class Services {

//	private boolean connectedMobile = false;
//	private boolean connectedWifi = false;
//
////	public String servicesUrl = "";
////	private String servicesPackage = "";
////	private String imei = "";
//
//	private WebServiceTask ws;
//
//	private Context context;
//
//	private List<String> lstAttribute = new ArrayList<String>();
//
////	private Parser parser;
////	private DialogConfirmation dialog_confirmation;
////	private long id_movil = 0;
//
//	private SharedPreferences configuration;
////	private Zone zone;
////	private String serviceUrlPublic;
////	private String servicesUrlPhoto;
//	/****************************************/
//	/*-----------SERVICES NAMES-------------*/
//	// --/usuario/--
//	// private static String TESTCOMUNICATION = "testCommunication";
////	private static String GET_USER = "leerUsuario";
//	// --/movil/--
////	private static String GET_CONFIGURATION_PARAMETER = "configuracionMovil";
////	private static String GET_IS_CLOSED_DAY = "diaCerrado";
////	private static String GET_IS_SYNCHRONIZED = "puedeSincronizar";
////	private static String GET_REFRESH_SYNCHRONIZED = "actualizarSincronizar";
////	private static String GET_REFRESH_CLOSED_DAY = "actualizarDiaCerrado";
////
////	private static String GET_ENTERPRISE = "listadoEmpresas";
////	// --/clasificador/--
////	private static String GET_CLASSIFIERS_BY = "clasificadorBy";
////
////	private static String POST_SEND_POSITION = "GuardarMarcacion";
////	// --/promocion/--
////	private static String GET_PROMOTION_LIST = "listarPromocionActivas";
////	// --/ruta/--
////	private static String GET_CLIENT_LIST = "listadodeClientes";
////	private static String GET_CLIENT_LIST_ROUTE = "listaClienteZona";
////	// --/ventas/--
////	private static String POST_SEND_VISIT = "enviarVisita";
////	private static String POST_SEND_VISIT_COLLECTION = "enviarColeccionVisitas";
////	private static String POST_SEND_ORDER = "enviarPedido";
////	private static String POST_SEND_ORDER_COLLECTION = "enviarColeccionPedidos";
////	private static String POST_SEND_SALE = "enviarVenta";
////	// --/clasificador/--
////	private static String GET_CLASSIFIERS = "clasificadorBy";
////	private static String GET_TYPE_CLASSIFIERS = "tipoClasificador";
////	// --/cliente/--
////	private static String POST_CLIENT = "GuardarCrPer";
////	private static String POST_CLIENT_COLLECTION = "enviarColeccionCliente";
////	private static String POST_CLIENT_PHOTO = "enviarClienteFoto";
////
////	private static String GET_CLIENT_PHOTO = "obtenerClienteFoto";
////	private static String GET_CLIENT = "obtenerCliente";
//
//	public Gson gson;
//
//	/*--------------------------------------*/
//
//	/*************************************************************************/
//	public Services(Context context) {
//		this.context = context;
//
//		configuration = context.getSharedPreferences("configuration", Context.MODE_PRIVATE);
//
//		if (!configuration.getString("webservice", "").isEmpty() && !configuration.getString("webservicepublic", "").isEmpty()) {
//			servicesUrl = configuration.getString("webservice", "");
//			serviceUrlPublic = configuration.getString("webservicepublic", "");
//			servicesUrlPhoto = configuration.getString("webservicePhoto", "");
//			if (Functions.isConnectedToWifi(context)) {
//				connectedWifi = true;
//			} else if (Functions.isConnectedToMobile(context)) {
//				connectedMobile = true;
//			}
////			imei = Functions.getImei(context);
//			// imei = "356928053587004"; // ace 3
//			// imei = "354073060662359"; //ace 4
//			// imei = "353563060719655"; //tab 4
//			// imei = "353563060719655"; // Grand Duo
//			// imei = "351780052156694"; // tank
//			// imei = "356928051376020"; // vinicius vallejos
//			// imei= "352167052125938"//note
//			// imei = "353515067746990" // grand
////			parser = new Parser();
//		} else {
//			try {
//				dialog_confirmation = new DialogConfirmation((Activity) context, DialogConfirmation.ALERT);
//				dialog_confirmation.setTitle("Advertencia");
//				dialog_confirmation.setDescription("Por favor indique la direccion del servidor en Configuraciones");
//				dialog_confirmation.setOnClickPositiveButton(new OnClickListener() {
//					@Override
//					public void onClick(View v) {
//						dialog_confirmation.dismiss();
//					}
//				});
//				dialog_confirmation.show();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//
//		gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateDeserializer()).create();
//
//	}
//
//	// public boolean isConnected() {
//	// return (connectedMobile || connectedWifi ? true : false);
//	// }
//
//	// ----------------------------------------------------------------------------------
//
//	// date-------------------------------------------------------
//	@SuppressWarnings("deprecation")
////	public boolean getServerDate() throws Exception {
////		if (isConnected()) {
////			try {
////				lstAttribute.clear();
////				ws = new WebServiceTask(this.context, servicesUrl + Constant.vCuentasNew, "", "ObtenerFecha", null, lstAttribute);
////				HttpEntity responseEntity = ws.getExecute().getEntity();
////				String sResponse = EntityUtils.toString(responseEntity, HTTP.UTF_8);
////
////				String a = sResponse.toString();
////
////				Date d = new Date(Long.valueOf(sResponse) * 1000);
////				Date d2 = Calendar.getInstance().getTime();
////
////				if (d.getYear() == d2.getYear() && d.getMonth() == d2.getMonth() && d.getDay() == d2.getDay()) {
////					return true;
////				} else {
////					return false;
////				}
////
////			} catch (Exception e) {
////				e.printStackTrace();
////				throw e;
////			}
////		}
////		return false;
////	}
////
////	// user-------------------------------------------------------
////	@SuppressLint("CommitPrefEdits")
////	public User getUser() throws Exception {
////		User user = null;
////		if (isConnected()) {
////			try {
////				user = new User();
////				lstAttribute.clear();
////				lstAttribute.add(imei);
////				servicesPackage = "usuario";
////				ws = new WebServiceTask(this.context, servicesUrl + Constant.vMobileNew, servicesPackage, GET_USER, null, lstAttribute);
////				HttpEntity responseEntity = ws.getExecute().getEntity();
////
////				JSONObject objJson = new JSONObject(EntityUtils.toString(responseEntity, HTTP.UTF_8));
////				parser.userParser(objJson, user);
////				JSONArray jsonarrayZona = new JSONArray();
////				jsonarrayZona = objJson.getJSONArray("listZona");
////
////				for (int i = 0; i < jsonarrayZona.length(); i++) {
////					zone = new Zone();
////					objJson = jsonarrayZona.getJSONObject(i);
////					parser.zoneParser(objJson, zone);
////					zone.StateType(StateType.insert);
////					user.getLstZone().add(zone);
////				}
////
////				user.StateType(StateType.insert);
////
////			} catch (Exception e) {
////				e.printStackTrace();
////				throw e;
////			}
////
////		} else {
////			connectionAlert();
////		}
////
////		return user;
////	}
////
////	// key ---------------------------------------
////	public boolean getEnterpriseWithKey(String sKey) throws Exception {
////		if (isConnected()) {
////			try {
////				lstAttribute.clear();
////				lstAttribute.add(sKey);
////				servicesPackage = "";
////				ws = new WebServiceTask(this.context, servicesUrl + Constant.vMobileNew, servicesPackage, "ObtenerEmpresa", null, lstAttribute);
////				HttpEntity responseEntity = ws.getExecute().getEntity();
////				String sResponse = EntityUtils.toString(responseEntity, HTTP.UTF_8);
////				SharedPreferences.Editor editor = configuration.edit();
////				editor.putString("enterpriseid", sResponse);
////				editor.commit();
////			} catch (Exception e) {
////				e.printStackTrace();
////				throw e;
////			}
////		}
////		return false;
////	}
//
//	// configuration parameter------------------------------------
//	public List<Product> getConfigurationsParameter(long id_movil) throws Exception {
//		List<ConfigurationParameter> list = new ArrayList<ConfigurationParameter>();
//		servicesPackage = "movil";
//		ConfigurationParameter obj;
//		JSONObject objJson;
//		lstAttribute.clear();
//		lstAttribute.add(String.valueOf(id_movil));
//		lstAttribute.add(imei);
//		if (isConnected()) {
//			try {
//				ws = new WebServiceTask(this.context, servicesUrl + Constant.vMobileNew, servicesPackage, GET_CONFIGURATION_PARAMETER, null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//				JSONArray items = new JSONArray(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//				int position;
//				for (position = 0; position < items.length(); position++) {
//
//					obj = new ConfigurationParameter();
//					objJson = items.getJSONObject(position);
//
//					parser.configurationParameterParser(objJson, obj);
//					obj.StateType(StateType.insert);
//					list.add(obj);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		} else {
//			connectionAlert();
//		}
//
//		return list;
//	}
//
//	// -----------------------------------------------------------
//
//	// is synchronized--------------------------------------------
//	public User getIsSynchronized(User user) throws Exception {
//		if (isConnected()) {
//			try {
//				lstAttribute.clear();
//				lstAttribute.add(String.valueOf(user.getlIdMovil()));
//				lstAttribute.add(imei);
//				servicesPackage = "movil";
//				ws = new WebServiceTask(this.context, servicesUrl + Constant.vMobileNew, servicesPackage, GET_IS_SYNCHRONIZED, null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//
//				user.setBtIsSynchronized(Boolean.parseBoolean(EntityUtils.toString(responseEntity, HTTP.UTF_8).toString()) ? 1 : 0);
//				user.StateType(StateType.insert);
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		} else {
//			connectionAlert();
//		}
//
//		return user;
//	}
//
//	// -----------------------------------------------------------
//
//	// day closed-------------------------------------------------
//	public User getIsDayClosed(User user) throws Exception {
//		if (isConnected()) {
//			try {
//				lstAttribute.clear();
//				lstAttribute.add(String.valueOf(user.getlIdMovil()));
//				lstAttribute.add(imei);
//				servicesPackage = "movil";
//				ws = new WebServiceTask(this.context, servicesUrl + Constant.vMobileNew, servicesPackage, GET_IS_CLOSED_DAY, null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//
//				user.setBtDayClosed(Boolean.parseBoolean(EntityUtils.toString(responseEntity, HTTP.UTF_8).toString()) ? 1 : 0);
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		} else {
//			connectionAlert();
//		}
//
//		return user;
//	}
//
//	// -----------------------------------------------------------
//
//	// classifiers------------------------------------------------
//	public List<Classifiers> getClassifiers(String id_typeClassifiers, String keySesion, String userCode, long id_movil) throws Exception {
//		List<Classifiers> list = new ArrayList<Classifiers>();
//		servicesPackage = "clasificador";
//		Classifiers obj;
//		JSONObject objJson;
//		lstAttribute.clear();
//		lstAttribute.add(keySesion);
//		lstAttribute.add(userCode);
//		lstAttribute.add(imei);
//		lstAttribute.add(String.valueOf(id_movil));
//		lstAttribute.add(id_typeClassifiers);
//		if (isConnected()) {
//			try {
//				ws = new WebServiceTask(this.context, servicesUrl + Constant.vMobileNew, servicesPackage, GET_CLASSIFIERS_BY, null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//				JSONArray items = new JSONArray(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//				int position;
//				for (position = 0; position < items.length(); position++) {
//					obj = new Classifiers();
//					objJson = items.getJSONObject(position);
//					parser.classifiersParser(objJson, obj);
//					obj.StateType(StateType.insert);
//					list.add(obj);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		} else {
//			connectionAlert();
//		}
//
//		return list;
//	}
//
//	public List<Enterprise> getEnterprise() throws Exception {
//		List<Enterprise> lstEnterprise = new ArrayList<Enterprise>();
//		JSONObject objJson;
//		Enterprise obj;
//		lstAttribute.clear();
//		servicesPackage = "";
//		if (isConnected()) {
//			try {
//				ws = new WebServiceTask(this.context, servicesUrl + Constant.vCuentasNew, servicesPackage, GET_ENTERPRISE, null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//				JSONArray items = new JSONArray(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//				for (int position = 0; position < items.length(); position++) {
//					obj = new Enterprise();
//					objJson = items.getJSONObject(position);
//					parser.enterpriseParse(objJson, obj);
//					obj.StateType(StateType.insert);
//					lstEnterprise.add(obj);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		} else {
//			connectionAlert();
//		}
//		return lstEnterprise;
//	}
//
//	public List<Currency> getCurrency(String keySesion) throws Exception {
//		List<Currency> lstCurrency = new ArrayList<Currency>();
//		JSONObject objJson;
//		Currency obj;
//		ExchangeRate objExchange;
//		JSONObject objJExchangeRate;
//		lstAttribute.clear();
//		lstAttribute.add(keySesion);
//		servicesPackage = "";
//		if (isConnected()) {
//			try {
//				ws = new WebServiceTask(context, servicesUrl + Constant.vCuentasNew, servicesPackage, "obtenerMonedas", null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//				JSONArray itemsCurrency = new JSONArray(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//				int i = 1;
//				for (int position = 0; position < itemsCurrency.length(); position++) {
//					if (i < 3) {
//						obj = new Currency();
//						objExchange = new ExchangeRate();
//						objJson = itemsCurrency.getJSONObject(position);
//						parser.currencyParser(objJson, obj);
//						obj.StateType(StateType.insert);
//
//						lstAttribute.clear();
//						lstAttribute.add(keySesion);
//						lstAttribute.add(String.valueOf(obj.getlId()));
//						lstAttribute.add(new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Calendar.getInstance().getTime()));
//
//						ws = new WebServiceTask(context, servicesUrl + Constant.vCuentasNew, servicesPackage, "ObtenerMantTC", null, lstAttribute);
//						responseEntity = ws.getExecute().getEntity();
//						objJExchangeRate = new JSONObject(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//						parser.exchangeRate(objJExchangeRate, objExchange);
//						objExchange.StateType(StateType.insert);
//
//						obj.setExchangeRate(objExchange);
//
//						lstCurrency.add(obj);
//						i++;
//					}
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		} else {
//			connectionAlert();
//		}
//		return lstCurrency;
//	}
//
//	public void getAccessModule(List<ConfigurationParameter> lstConfigurationParameters, User user) throws Exception {
//		lstAttribute.clear();
//		lstAttribute.add(String.valueOf(user.getlIdMovil()));
//		lstAttribute.add(imei);
//		servicesPackage = "movil";
//
//		if (isConnected()) {
//			try {
//				ws = new WebServiceTask(context, servicesUrl + Constant.vMobileNew, servicesPackage, "modulosMovil", null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//				JSONArray itemsPreferences = new JSONArray(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//				for (int i = 0; i < itemsPreferences.length(); i++) {
//					JSONObject objJson = new JSONObject();
//					ConfigurationParameter configurationParameter = new ConfigurationParameter();
//					objJson = itemsPreferences.getJSONObject(i);
//					configurationParameter.setsName(objJson.getString("id"));
//					configurationParameter.setsValue(objJson.getString("nombre"));
//					configurationParameter.StateType(StateType.insert);
//					lstConfigurationParameters.add(configurationParameter);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		} else {
//			connectionAlert();
//		}
//	}
//
//	public User getSellerPreferences(String keySesion, User user) throws Exception {
//
//		JSONObject objJson;
//		JSONObject objJsonDetail;
//		JSONArray objDetailArray;
//		SellerPreferencesDetail objDetail;
//		lstAttribute.clear();
//		lstAttribute.add(keySesion);
//		lstAttribute.add(user.getsUserCode());
//		lstAttribute.add(imei);
//		lstAttribute.add(String.valueOf(user.getlIdMovil()));
//		servicesPackage = "";
//
//		if (isConnected()) {
//			try {
//				ws = new WebServiceTask(context, servicesUrl + Constant.vMobileNew, servicesPackage, "BuscarMaprv", null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//				objJson = new JSONObject(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//				objDetailArray = objJson.getJSONArray("Dtll");
//				parser.SellerPreferencesParser(objJson, user);
//				for (int position = 0; position < objDetailArray.length(); position++) {
//					objDetail = new SellerPreferencesDetail();
//					objJsonDetail = objDetailArray.getJSONObject(position);
//					parser.SellerPreferencesDetailParser(objJsonDetail, objDetail);
//					objDetail.StateType(StateType.insert);
//
//					user.getLstSellerPreferences().add(objDetail);
//					user.StateType(StateType.insert);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		} else {
//			connectionAlert();
//		}
//		return user;
//	}
//
//	public List<CustomerParameter> getPreferences(String keySesion, String code, long lIdMovil, List<Customer> lstCustomer, List<CustomerPriceList> lstCustomerPriceLists, User user) throws Exception {
//		List<CustomerParameter> lstCustomerParameterAux = new ArrayList<CustomerParameter>();
//		List<CustomerParameter> lstCustomerParameter = new ArrayList<CustomerParameter>();
//		List<CustomerParameterDetail> lstCustomerParameterDetail = new ArrayList<CustomerParameterDetail>();
//		CustomerPriceList customerPriceList;
//		CustomerParameter customerParameter;
//		JSONObject objJson;
//		JSONObject objJsonDetail;
//		JSONArray objDetailArray;
//		CustomerParameter obj;
//		CustomerParameterDetail objDetail;
//		lstAttribute.clear();
//		lstAttribute.add(keySesion);
//		lstAttribute.add(code);
//		lstAttribute.add(imei);
//		lstAttribute.add(String.valueOf(lIdMovil));
//		lstAttribute.add("0");
//		if (isConnected()) {
//			try {
//				ws = new WebServiceTask(context, servicesUrl + Constant.vMobileNew, servicesPackage, "ObtenerListaPreferencias", null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//				JSONArray itemsPreferences = new JSONArray(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//
//				for (int position = 0; position < itemsPreferences.length(); position++) {
//					obj = new CustomerParameter();
//					objJson = itemsPreferences.getJSONObject(position);
//					parser.PreferencesParser(objJson, obj);
//					lstCustomerParameterDetail = new ArrayList<CustomerParameterDetail>();
//					objDetailArray = objJson.getJSONArray("Dtll");
//					for (int index = 0; index < objDetailArray.length(); index++) {
//						objDetail = new CustomerParameterDetail();
//						objJsonDetail = objDetailArray.getJSONObject(index);
//						parser.preferencesDetailParser(objJsonDetail, objDetail);
//						objDetail.StateType(StateType.insert);
//						lstCustomerParameterDetail.add(objDetail);
//					}
//					obj.setLstCustomerParameterDetail(lstCustomerParameterDetail);
//					lstCustomerParameterAux.add(obj);
//				}
//
//				for (Customer customer : lstCustomer) {
//					for (CustomerParameter customerParameterAux : lstCustomerParameterAux) {
//						if (customer.getiClsf() == customerParameterAux.getlId()) {
//							customerParameter = new CustomerParameter();
//
//							customerParameter.setlId(customerParameterAux.getlId());
//							customerParameter.setlIdCustomer(customerParameterAux.getlIdCustomer());
//							customerParameter.setlIdcPaymentType(customerParameterAux.getlIdcPaymentType());
//							customerParameter.setdCreditLimit(customerParameterAux.getdCreditLimit());
//							customerParameter.setdDebt(customerParameterAux.getdDebt());
//							customerParameter.setiShareLimit(customerParameterAux.getiShareLimit());
//							customerParameter.setiShareExpired(customerParameterAux.getiShareExpired());
//							customerParameter.setlIdCurrency(customerParameterAux.getlIdCurrency());
//							customerParameter.setlIdcPaymentType(90);
//
//							customerParameter.setlIdCustomer(customer.getlId());
//							customerParameter.StateType(StateType.insert);
//
//							for (CustomerParameterDetail customerParameterDetail : customerParameterAux.getLstCustomerParameterDetail()) {
//								for (SellerPreferencesDetail sellerPreferences : user.getLstSellerPreferences()) {
//									if (sellerPreferences.getlIdList() == customerParameterDetail.getlIdPriceList()) {
//										customerPriceList = new CustomerPriceList();
//										customerPriceList.setlIdCompany(customerParameterDetail.getlIdLocal());
//										customerPriceList.setlIdCustomer(customer.getlId());
//										customerPriceList.setlIdPriceList(customerParameterDetail.getlIdPriceList());
//										customerPriceList.StateType(StateType.insert);
//										lstCustomerPriceLists.add(customerPriceList);
//										customerParameter.setlIdCompany(customerParameterDetail.getlIdLocal());
//									}
//								}
//							}
//							lstCustomerParameter.add(customerParameter);
//							break;
//						}
//					}
//				}
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		} else {
//			connectionAlert();
//		}
//		return lstCustomerParameter;
//	}
//
//	// public PreferablyMobile getPreferencesMobile(String keySesion, String code, long lIdMovil) throws Exception {
//	// PreferablyMobile objPreMobile = new PreferablyMobile();
//	// JSONObject objJson;
//	// lstAttribute.clear();
//	// lstAttribute.add(keySesion);
//	// lstAttribute.add(code);
//	// lstAttribute.add(imei);
//	// lstAttribute.add(String.valueOf(lIdMovil));
//	// if (isConnected()) {
//	// try {
//	// ws = new WebServiceTask(context, servicesUrl + Constant.vMobileNew, servicesPackage, "BuscarPreferenciasMovil", null, lstAttribute);
//	// HttpEntity responseEntity = ws.getExecute().getEntity();
//	// objJson = new JSONObject(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//	//
//	// parser.prefereablyMobileParser(objJson, objPreMobile);
//	// objPreMobile.StateType(StateType.insert);
//	// } catch (Exception e) {
//	// e.printStackTrace();
//	// throw e;
//	// }
//	// } else {
//	// connectionAlert();
//	// }
//	// return objPreMobile;
//	// }
//
//	// -----------------------------------------------------------
//
//	// customer---------------------------------------------------
//	@SuppressLint("UseValueOf")
//	public List<Customer> getCustomer(String keySesion, String userCode, long id_movil, List<Sale> lstSale) throws Exception {
//		List<Customer> list = new ArrayList<Customer>();
//		List<Integer> listRuta = new ArrayList<Integer>();
//		int position;
//		Customer obj;
//		CustomerPriceList objPriceList;
//		CustomerParameter objParameter;
//		HttpEntity responseEntity;
//		servicesPackage = "";
//		lstAttribute.clear();
//		lstAttribute.add(keySesion);
//		lstAttribute.add(userCode);
//		lstAttribute.add(imei);
//		lstAttribute.add(String.valueOf(id_movil));
//		if (isConnected()) {
//			try {
//				ws = new WebServiceTask(this.context, servicesUrl + Constant.vMobileNew, servicesPackage, "ObtenerCarteraClientes", null, lstAttribute);
//				responseEntity = ws.getExecute().getEntity();
//				JSONArray itemsCliente = new JSONArray(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//
//				ws = new WebServiceTask(context, servicesUrl + Constant.vMobileNew, servicesPackage, "ObtenerClientesZonaVmLoc", null, lstAttribute);
//				responseEntity = ws.getExecute().getEntity();
//				JSONArray itemsClienteZona = new JSONArray(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//
//				lstAttribute.add(new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Calendar.getInstance().getTime()));
//				// lstAttribute.add("2015-04-17");
//				ws = new WebServiceTask(context, servicesUrl + Constant.vMobileNew, servicesPackage, "ObtenerRutaDia", null, lstAttribute);
//				responseEntity = ws.getExecute().getEntity();
//				JSONArray itemsClienteRuta = new JSONArray(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//
//				for (position = 0; position < itemsClienteRuta.length(); position++) {
//					listRuta.add(itemsClienteRuta.getJSONObject(position).getInt("Cent"));
//				}
//
//				for (position = 0; position < itemsCliente.length(); position++) {
//					JSONObject objs = new JSONObject();
//					JSONObject objsZona = new JSONObject();
//					JSONObject objsEn = new JSONObject();
//					JSONObject objRuta = new JSONObject();
//					obj = new Customer();
//					objs = itemsCliente.getJSONObject(position);
//					objsZona = itemsClienteZona.getJSONObject(position);
//					objsEn = objs.getJSONObject("crEnt");
//					parser.customerParser(objs, obj, objsEn, objsZona);
//					if (listRuta.contains(new Integer((int) obj.getlId()))) {
//						int i = clienteRuta(obj.getlId(), listRuta);
//						objRuta = itemsClienteRuta.getJSONObject(i);
//						obj.setiPath(objRuta.getInt("Ordn"));
//						// esto es para distribucion
//						if (objRuta.get("Pedido") != null && !objRuta.get("Pedido").toString().contains("null")) {
//							JSONObject objPedido = objRuta.getJSONObject("Pedido");
//							Sale sale = new Sale();
//							parser.saleParser(objPedido, sale);
//							sale.StateType(StateType.insert);
//
//							JSONArray objArrayDetalle = new JSONArray();
//							objArrayDetalle = objPedido.getJSONArray("Dtll");
//							List<SaleDetail> lstDetail = new ArrayList<SaleDetail>();
//
//							for (int j = 0; j < objArrayDetalle.length(); j++) {
//								SaleDetail saleDetail = new SaleDetail();
//								parser.saleDetailParser(objArrayDetalle.getJSONObject(j), saleDetail);
//								saleDetail.StateType(StateType.insert);
//								lstDetail.add(saleDetail);
//							}
//							sale.setListSaleDetail(lstDetail);
//							sale.setlIdcSaleType(101);
//							sale.setBtSent(1);
//							sale.setBtValid(1);
//							lstSale.add(sale);
//						}
//					}
//					obj.setBtSend(1);
//					obj.setBtNewUser(0);
//					obj.StateType(StateType.insert);
//					list.add(obj);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		} else {
//			connectionAlert();
//		}
//
//		return list;
//	}
//
//	@SuppressLint("UseValueOf")
//	private int clienteRuta(long getlId, List<Integer> listRuta) {
//		int index = 0;
//		for (Integer integer : listRuta) {
//
//			if (integer != null && new Integer((int) getlId).equals(integer))
//				return index;
//			index++;
//		}
//		return -1;
//	}
//
//	public List<Receivable> getCuentasxCobrar(String keySesion, String code, long lIdMovil, String codeZone) throws Exception {
//		List<Receivable> lstReceivables = new ArrayList<Receivable>();
//		JSONArray jsonArray;
//		lstAttribute.clear();
//		servicesPackage = "";
//		lstAttribute.add(keySesion);
//		lstAttribute.add(code);
//		lstAttribute.add(imei);
//		lstAttribute.add(String.valueOf(lIdMovil));
//		lstAttribute.add(String.valueOf(codeZone));
//		if (isConnected()) {
//			try {
//				ws = new WebServiceTask(context, servicesUrl + Constant.vMobileNew, servicesPackage, "ObtenerCxCClientesZona", null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//				jsonArray = new JSONArray(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//				JSONObject objJson;
//				for (int i = 0; i < jsonArray.length(); i++) {
//					objJson = new JSONObject();
//					Receivable receivable = new Receivable();
//					objJson = jsonArray.getJSONObject(i);
//					parser.receivableParser(objJson, receivable);
//					receivable.StateType(StateType.insert);
//					lstReceivables.add(receivable);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		} else {
//			connectionAlert();
//		}
//		return lstReceivables;
//	}
//
//	// -----------------------------------------------------------
//
//	public Company getLocal(String keySesion, String code, long lIdMovil, long lIdLocal) throws Exception {
//		Company objLocal = new Company();
//		JSONObject objJson;
//		lstAttribute.clear();
//		lstAttribute.add(keySesion);
//		lstAttribute.add(code);
//		lstAttribute.add(imei);
//		lstAttribute.add(String.valueOf(lIdMovil));
//		lstAttribute.add(String.valueOf(lIdLocal));
//		if (isConnected()) {
//			try {
//				ws = new WebServiceTask(context, servicesUrl + Constant.vMobileNew, servicesPackage, "BuscarLocal", null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//				objJson = new JSONObject(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//
//				parser.companyParser(objJson, objLocal);
//
//				objLocal.StateType(StateType.insert);
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		} else {
//			connectionAlert();
//		}
//
//		return objLocal;
//	}
//
//	public Stock getStock(String keySesion, String code, long lIdMovil, long getlIdLocal, long lIdMobileStock) throws Exception {
//		Stock objStock = new Stock();
//		JSONObject objJson;
//		lstAttribute.clear();
//		lstAttribute.add(keySesion);
//		lstAttribute.add(code);
//		lstAttribute.add(imei);
//		lstAttribute.add(String.valueOf(lIdMovil));
//		lstAttribute.add(String.valueOf(lIdMobileStock));
//		if (isConnected()) {
//			try {
//				ws = new WebServiceTask(context, servicesUrl + Constant.vMobileNew, servicesPackage, "BuscarAlmacen", null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//				objJson = new JSONObject(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//
//				parser.stockParser(objJson, objStock);
//
//				objStock.StateType(StateType.insert);
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		} else {
//			connectionAlert();
//		}
//		return objStock;
//	}
//
//	// product----------------------------------------------------
//	public List<Product> getProduct(String keySesion, String code, long lIdMovil, long lIdPriceList) throws Exception {
//		List<Product> list = new ArrayList<Product>();
//		Product obj;
//		UnitMeasure objUnit;
//		ProductStock objStock;
//		JSONArray objJArrayDetail;
//		JSONObject objDetail;
//		servicesPackage = "";
//		lstAttribute.clear();
//		lstAttribute.add(keySesion);
//		lstAttribute.add(code);
//		lstAttribute.add(imei);
//		lstAttribute.add(String.valueOf(lIdMovil));
//		lstAttribute.add(String.valueOf(lIdPriceList));
//		lstAttribute.add(new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Calendar.getInstance().getTime()));
//		if (isConnected()) {
//			try {
//				ws = new WebServiceTask(this.context, servicesUrl + Constant.vMobileNew, servicesPackage, "BuscarListaVenta2", null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//				JSONArray items = new JSONArray(EntityUtils.toString(responseEntity));
//
//				int position;
//				for (position = 0; position < items.length(); position++) {
//					JSONObject objs = new JSONObject();
//					obj = new Product();
//					objs = items.getJSONObject(position);
//					parser.productParser(objs, obj);
//					obj.StateType(StateType.insert);
//
//					objJArrayDetail = objs.getJSONArray("DetUMs");
//
//					for (int index = 0; index < objJArrayDetail.length(); index++) {
//						objUnit = new UnitMeasure();
//						objDetail = objJArrayDetail.getJSONObject(index);
//						parser.unitMeasureParser(objDetail, objUnit);
//						objUnit.StateType(StateType.insert);
//
//						obj.getLstUnitMeasure().add(objUnit);
//					}
//
//					objStock = new ProductStock();
//					parser.productStockParser(objs, objStock);
//					objStock.StateType(StateType.insert);
//
//					obj.setProductStock(objStock);
//					// -----------------------
//					obj.setlIdCompany(1);
//					obj.setlIdcDiscountType(98);
//					// obj.setdDiscountLimit(0.0);
//					// -------------------------
//					list.add(obj);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		} else {
//			connectionAlert();
//		}
//
//		return list;
//	}
//
//	// -----------------------------------------------------------
//
//	// DeferredSales----------------------------------------------------
//	public void getDeferredSales(long getlIdMovil, List<Sale> lstSale) throws Exception {
//		JSONArray array = new JSONArray();
//		JSONArray detailArray;
//		JSONObject obj;
//		JSONObject detail;
//		Sale sale;
//		SaleDetail saleDetail;
//		servicesPackage = "ruta";
//		lstAttribute.clear();
//		lstAttribute.add(String.valueOf(getlIdMovil));
//		lstAttribute.add(new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Calendar.getInstance().getTime()));
//		if (isConnected()) {
//			try {
//				ws = new WebServiceTask(this.context, servicesUrl + Constant.vMobileNew, servicesPackage, "listadodeClientesVentaDiferida", null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//				String sResponse = EntityUtils.toString(responseEntity, HTTP.UTF_8);
//
//				sResponse = sResponse.replace("\\", "");
//				sResponse = sResponse.substring(1, sResponse.length() - 1);
//
//				array = new JSONArray(sResponse);
//				for (int i = 0; i < array.length(); i++) {
//					obj = new JSONObject();
//					sale = new Sale();
//					obj = array.getJSONObject(i).getJSONObject("venta");
//					parser.DeferredSales(obj, sale);
//					detailArray = obj.getJSONArray("Dtll");
//					for (int a = 0; a < detailArray.length(); a++) {
//						detail = new JSONObject();
//						saleDetail = new SaleDetail();
//						detail = detailArray.getJSONObject(a);
//						parser.DeferredSalesDetail(detail, saleDetail);
//						saleDetail.StateType(StateType.insert);
//						sale.getListSaleDetail().add(saleDetail);
//					}
//					sale.setlIdcSaleType(100);
//					sale.setBtSent(1);
//					sale.setBtValid(1);
//					sale.StateType(StateType.insert);
//					lstSale.add(sale);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		} else {
//			connectionAlert();
//		}
//	}
//
//	// -----------------------------------------------------------
//
//	// priceList----------------------------------------------------
//	public List<PriceList> getPriceList(String keySesion, String code, long lIdMovil, long lIdLocal) throws Exception {
//		List<PriceList> list = new ArrayList<PriceList>();
//		PriceList obj;
//		PriceListProduct objDetail;
//		JSONObject objJson;
//		JSONObject objJsonDetail;
//		JSONArray itemsDetail;
//		List<PriceListProduct> lstPriceListProduct;
//		servicesPackage = "";
//		lstAttribute.clear();
//		lstAttribute.add(keySesion);
//		lstAttribute.add(code);
//		lstAttribute.add(imei);
//		lstAttribute.add(String.valueOf(lIdMovil));
//		lstAttribute.add(String.valueOf(lIdLocal));
//		if (isConnected()) {
//			try {
//				ws = new WebServiceTask(this.context, servicesUrl + Constant.vMobileNew, servicesPackage, "ListaXLocal", null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//				JSONArray items = new JSONArray(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//
//				int position;
//				for (position = 0; position < items.length(); position++) {
//					objJson = new JSONObject();
//					obj = new PriceList();
//					objJson = items.getJSONObject(position);
//					parser.priceListParser(objJson, obj);
//
//					lstPriceListProduct = new ArrayList<PriceListProduct>();
//					itemsDetail = objJson.getJSONArray("Detalle");
//					for (int index = 0; index < itemsDetail.length(); index++) {
//						objDetail = new PriceListProduct();
//						objJsonDetail = itemsDetail.getJSONObject(index);
//						parser.priceListProductParser(objJsonDetail, objDetail);
//						objDetail.StateType(StateType.insert);
//						lstPriceListProduct.add(objDetail);
//					}
//					obj.setListPriceListProduct(lstPriceListProduct);
//					obj.StateType(StateType.insert);
//					// -----------------------------
//					obj.setlIdCompany(1);
//					// -----------------------------
//					list.add(obj);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		} else {
//			connectionAlert();
//		}
//
//		return list;
//	}
//
//	// -----------------------------------------------------------
//
//	// priceListProduct----------------------------------------------------
//	public List<PriceListProduct> getPriceListProduct(List<PriceList> lstPriceList) throws Exception {
//		List<PriceListProduct> list = new ArrayList<PriceListProduct>();
//		PriceListProduct obj;
//		servicesPackage = "producto";
//		lstAttribute.clear();
//		if (isConnected()) {
//			try {
//				for (int i = 0; i < lstPriceList.size(); i++) {
//					lstAttribute.clear();
//					lstAttribute.add(String.valueOf(lstPriceList.get(i).getlId()));
//					ws = new WebServiceTask(this.context, servicesUrl, servicesPackage, "listaPrecioProducto", null, lstAttribute);
//					HttpEntity responseEntity = ws.getExecute().getEntity();
//					JSONArray items = new JSONArray(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//
//					int position;
//					for (position = 0; position < items.length(); position++) {
//						JSONObject objs = new JSONObject();
//						obj = new PriceListProduct();
//						objs = items.getJSONObject(position);
//						parser.priceListProductParser(objs, obj);
//						obj.StateType(StateType.insert);
//						list.add(obj);
//					}
//
//				}
//
//				// --------------------------------------------
//
//				// --------------------------------------------
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		} else {
//			connectionAlert();
//		}
//
//		return list;
//	}
//
//	// -----------------------------------------------------------
//
//	// -----------------------------------------------------------
//
//	// customerParameter------------------------------------------
//	public List<CustomerParameter> getCustomerParameter(List<Customer> lstCustomer) {
//		List<CustomerParameter> lstCustomerParameter = new ArrayList<CustomerParameter>();
//		CustomerParameter obj;
//		for (Customer customer : lstCustomer) {
//			obj = new CustomerParameter();
//			obj.setlIdCompany(1);
//			obj.setlIdCustomer(customer.getlId());
//			obj.setlIdcPaymentType(89);
//			obj.setdCreditLimit(10000.0);
//			obj.setdDebt(0);
//			obj.StateType(StateType.insert);
//			lstCustomerParameter.add(obj);
//		}
//		return lstCustomerParameter;
//	}
//
//	// -----------------------------------------------------------
//
//	// invoice ----------------------------------------------------
//	public List<Invoice> getInvoice(long idVendedor) throws Exception {
//		List<Invoice> list = new ArrayList<Invoice>();
//		Invoice obj;
//		servicesPackage = "cobranza";
//		lstAttribute.clear();
//		if (isConnected()) {
//			try {
//				lstAttribute.add(String.valueOf(idVendedor));
//				ws = new WebServiceTask(this.context, servicesUrl, servicesPackage, "documentosPendientes", null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//				JSONArray items = new JSONArray(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//				for (int position = 0; position < items.length(); position++) {
//					JSONObject objs = new JSONObject();
//					obj = new Invoice();
//					objs = items.getJSONObject(position);
//					obj.setIdCustomer(objs.getLong("idCliente"));
//					obj.setIdCompany(1);
//					obj.setManagement(objs.getInt("gestion"));
//					obj.setLedger(objs.getLong("cuenta"));
//					obj.setInvoiceNumber(String.valueOf(objs.getInt("nro_transaccion")));
//					obj.setShareInvoice(objs.getInt("cuota"));
//					obj.setItemShareInvoice(objs.getInt("item"));
//					obj.setInvoiceDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(objs.getString("fecha_transaccion")));
//					obj.setInvoiceAmount(objs.getDouble("importe_total"));
//					obj.setExpirationDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(objs.getString("fecha_vencimiento")));
//					obj.setDebt(objs.getDouble("importe_total"));
//					obj.setValid(1);
//					obj.setlIdServer(objs.getLong("id"));
//					obj.setValid(1);
//
//					obj.StateType(StateType.insert);
//					list.add(obj);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw e;
//			}
//		} else {
//			connectionAlert();
//		}
//
//		return list;
//	}
//
//	public List<Photo> getCustomerPhoto(long idCliente, ImageView View, String keySesion, String userCode, long id_movil) {
//		List<Photo> list = new ArrayList<Photo>();
//		Photo obj;
//		servicesPackage = "";
//		if (isConnected()) {
//			try {
//				lstAttribute.clear();
//				lstAttribute.add(keySesion);
//				lstAttribute.add(userCode);
//				lstAttribute.add(imei);
//				lstAttribute.add(String.valueOf(id_movil));
//				lstAttribute.add(String.valueOf(idCliente));
//				ws = new WebServiceTask(this.context, servicesUrl + Constant.vMobileNew, servicesPackage, "ObtenerVmpics", null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//				JSONArray items = new JSONArray(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//
//				int position;
//				JSONArray lstImagen;
//				parser = new Parser();
//				if (items.length() > 0) {
//					for (position = 0; position < items.length(); position++) {
//						JSONObject objs = new JSONObject();
//						objs = items.getJSONObject(position);
//						obj = new Photo();
//						parser.photoParser(objs, obj);
//						obj.setBtSent(1);
//						obj.StateType(StateType.insert);
//						String url_server = Constant.DIRSERVERIMAGE + objs.getString("FDir");
//						obj.setsUrl(url_server);
//						list.add(obj);
//
//					}
//					new task(list, View).execute();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else {
//			connectionAlert();
//		}
//
//		return list;
//	}
//
//	public List<Long> getidLocal(String keySesion) {
//		List<Long> lstLocal = new ArrayList<Long>();
//		servicesPackage = "";
//		if (isConnected()) {
//			try {
//				lstAttribute.clear();
//				lstAttribute.add(keySesion);
//				lstAttribute.add("0");
//				lstAttribute.add(imei);
//				lstAttribute.add("0");
//				ws = new WebServiceTask(this.context, servicesUrl + Constant.vMobileNew, servicesPackage, "LocalesXUsuario", null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//				JSONArray items = new JSONArray(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//
//				for (int position = 0; position < items.length(); position++) {
//					JSONObject objs = new JSONObject();
//					objs = items.getJSONObject(position);
//					lstLocal.add(objs.getLong("Cloc"));
//				}
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		} else {
//			connectionAlert();
//		}
//
//		return lstLocal;
//	}
//
//	public JSONArray getStockProduct(String keySesion, String codeProduct, String codeLocal) {
//		JSONArray arrayStockProduct = new JSONArray();
//		servicesPackage = "";
//		if (isConnected()) {
//			try {
//				lstAttribute.clear();
//				lstAttribute.add(keySesion);
//				lstAttribute.add(codeProduct);
//				lstAttribute.add(codeLocal);
//				ws = new WebServiceTask(this.context, servicesUrl + Constant.vMobileNew, servicesPackage, "BuscarStockProducto", null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//
//				String result = EntityUtils.toString(responseEntity, HTTP.UTF_8);
//				result = result.replace("\\", "");
//				// result = result.replaceAll("[^.:0-9a-zA-Z\\x5b\\x5d\\x7b\\x7d\", -]", "");
//				result = result.substring(1, result.length() - 1);
//
//				arrayStockProduct = new JSONArray(result);
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		} else {
//			connectionAlert();
//		}
//		return arrayStockProduct;
//	}
//
//	public boolean sendPath(UserPath userPath, Long idMovil) {
//		JSONObject objJson = new JSONObject();
//		boolean bResult = false;
//		servicesPackage = "movil";
//		if (isConnected()) {
//
//		} else {
//			connectionAlert();
//		}
//		if (userPath.getdLatitude() != null && userPath.getdLongitude() != null && userPath.getdtDatePath() != null && !servicesUrl.isEmpty()) {
//			try {
//				objJson.put("id", userPath.getlId());
//				objJson.put("id_usuario_movil", idMovil);
//				objJson.put("imei", Functions.getImei(context));
//				try {
//					objJson.put("fecha", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(userPath.getdtDatePath()));
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				objJson.put("latitud", userPath.getdLatitude());
//				objJson.put("longitud", userPath.getdLongitude());
//				ws = new WebServiceTask(context, servicesUrl, servicesPackage, POST_SEND_POSITION, objJson, null);
//
//				String s = EntityUtils.toString(ws.postExecute().getEntity());
//				return Boolean.valueOf(s);
//			} catch (Exception e) {
//				e.printStackTrace();
//				return false;
//			}
//		}
//		return false;
//	}
//
//	public boolean sendPath(UserPath userPath, User user, String keySesion) {
//		JSONObject objJson = new JSONObject();
//		JSONObject objUser = new JSONObject();
//
//		JSONArray objParams = new JSONArray();
//		boolean bResult = false;
//		servicesPackage = "";
//		if (isConnected()) {
//			if (userPath.getdLatitude() != null && userPath.getdLongitude() != null && userPath.getdtDatePath() != null && !servicesUrl.isEmpty()) {
//				try {
//					parser.sendUserParser(objUser, user);
//					parser.sendUserPathParser(objJson, userPath);
//
//					objParams.put(0, keySesion);
//					objParams.put(1, user.getsUserCode());
//					objParams.put(2, imei);
//					objParams.put(3, objUser.toString());
//					objParams.put(4, objJson.toString());
//
//					// objJson.put("id", userPath.getlId());
//					// objJson.put("id_usuario_movil", id_movil);
//					// objJson.put("imei", Functions.getImei(context));
//					// try {
//					// objJson.put("fecha", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(userPath.getdtDatePath()));
//					// } catch (Exception e) {
//					// e.printStackTrace();
//					// }
//					// objJson.put("latitud", userPath.getdLatitude());
//					// objJson.put("longitud", userPath.getdLongitude());
//					ws = new WebServiceTask(context, servicesUrl + Constant.vMobileNewPost, servicesPackage, POST_SEND_POSITION, objJson, null);
//					ws.setEntityArray(objParams);
//					String s = EntityUtils.toString(ws.postExecute().getEntity());
//					bResult = Boolean.valueOf(s);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		} else {
//			connectionAlert();
//		}
//
//		return bResult;
//	}
//
//	public long sendReason(Reason reason, User user) {
//
//		JSONArray objParams = new JSONArray();
//		JSONObject objReason = new JSONObject();
//		JSONObject objCustomer = new JSONObject();
//		servicesPackage = "ventas";
//		long lId = 0;
//		if (isConnected()) {
//			try {
//
//				objCustomer.put("id", reason.getCustomer().getiNSync());
//				objCustomer.put("codigoCliente", reason.getlIdCustomer());
//				// objCustomer.put("nombre", "");
//				// objCustomer.put("apellido_paterno", "");
//				// objCustomer.put("apellido_materno", "");
//				// objCustomer.put("nombreCompania", "");
//				// objCustomer.put("longitud", 0.0);
//				// objCustomer.put("idc_categoria", 0);
//				// objCustomer.put("fecha_registro", "");
//				// objCustomer.put("email", "");
//				// objCustomer.put("estado", true);
//				// objCustomer.put("pendiente", false);
//				// objCustomer.put("ci", "");
//				// objCustomer.put("giro", "");
//				// objCustomer.put("nombre_factura", "");
//				// objCustomer.put("fecha_nacimiento", "");
//				// objCustomer.put("idc_civil", 0);
//				// objCustomer.put("activo", true);
//				// objCustomer.put("id_zona", 0);
//				// objCustomer.put("codigo_pais", "");
//				// objCustomer.put("codigo_ciudad", "");
//				// objCustomer.put("codigo_clasificacion", "");
//
//				objReason.put("id", reason.getlId());
//				objReason.put("id_usuario_movil", user.getlIdMovil());
//				objReason.put("id_registro", 0);
//				objReason.put("id_cliente", reason.getlIdCustomer());
//				objReason.put("fecha_inicial", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(reason.getdReasonDate()));
//				objReason.put("fecha_final", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(reason.getdReasonDate()));
//				objReason.put("latitud", reason.getdLatitude());
//				objReason.put("longitud", reason.getdLongitude());
//				objReason.put("idc_motivo", reason.getlIdcReason());
//				objReason.put("observaciones", reason.getsDescription());
//				objReason.put("cliente", objCustomer);
//
//				objParams.put(0, String.valueOf(user.getlIdMovil()));
//				objParams.put(1, objReason.toString());
//
//				ws = new WebServiceTask(context, servicesUrlPhoto, servicesPackage, "enviarVisita", objReason, null);
//				ws.setEntityArray(objParams);
//				String s = EntityUtils.toString(ws.postExecute().getEntity());
//
//				JSONArray result = new JSONArray(s);
//				return result.getLong(0);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else {
//			connectionAlert();
//		}
//
//		return 0;
//	}
//
//	@SuppressLint("NewApi")
//	public long sendCustomer(Customer customer, User user, String keySesion, List<String> lstError) {
//		JSONArray objParams = new JSONArray();
//		JSONObject objJson = new JSONObject();
//		JSONObject objJEn = new JSONObject();
//		JSONObject objJZona = new JSONObject();
//		JSONObject objUser = new JSONObject();
//		Date date = Calendar.getInstance().getTime();
//
//		String resultado = "";
//		String error = "";
//		long id_server = 0;
//		servicesPackage = "";
//		boolean bResult = false;
//		String[] lastName = null;
//		if (isConnected()) {
//			try {
//
//				parser.sendUserParser(objUser, user);
//				parser.sendCustomerParser(objJson, customer, keySesion);
//				parser.sendZoneCustomerParser(objJZona, customer);
//
//				objParams.put(0, keySesion);
//				objParams.put(1, user.getsUserCode());
//				objParams.put(2, imei);
//				objParams.put(3, objJson.toString());
//				objParams.put(4, objUser.toString());
//				objParams.put(5, objJZona.toString());
//
//				ws = new WebServiceTask(context, servicesUrl + Constant.vMobileNewPost, servicesPackage, POST_CLIENT, objJson, null);
//				ws.setEntityArray(objParams);
//
//				resultado = EntityUtils.toString(ws.postExecute().getEntity(), HTTP.UTF_8);
//				long id = Integer.parseInt(resultado);
//
//				return id;
//			} catch (Exception e) {
//				String[] ss = error.split("'");
//				error = "Enviar cliente:" + "\n" + "Id:" + customer.getlId() + "\n" + "Cliente:" + customer.getsSocialReason() + "\n" + "Error:" + ss[1] + "\n" + "----------------------------";
//				lstError.add(error);
//			}
//		} else {
//			connectionAlert();
//		}
//
//		return -1;
//	}
//
//	public long sendSale(Sale sale, User user, String keySesion, List<String> error) {
//		JSONObject objJson = new JSONObject();
//		JSONArray objParams = new JSONArray();
//		JSONObject objUser = new JSONObject();
//		JSONObject objSale = new JSONObject();
//		JSONObject objPaymentSale = new JSONObject();
//		String errors = "";
//		long id_server = 0;
//		servicesPackage = "";
//		boolean bResult = false;
//		String s = null;
//		if (isConnected()) {
//			if (sale != null) {
//				try {
//
//					parser.sendUserParser(objUser, user);
//					parser.sendSaleParser(objSale, sale, user);
//					parser.sendPaymentParser(objPaymentSale, sale, user);
//
//					objParams.put(0, keySesion);
//					objParams.put(1, user.getsUserCode());
//					objParams.put(2, imei);
//					objParams.put(3, objUser.toString());
//					objParams.put(4, objSale.toString());
//					objParams.put(5, objPaymentSale.toString());
//
//					ws = new WebServiceTask(context, servicesUrl + Constant.vMobileNewPost, servicesPackage, "wsGuardarVentaCobro", objJson, null);
//					ws.setEntityArray(objParams);
//
//					// idServer
//
//					s = (EntityUtils.toString(ws.postExecute().getEntity(), HTTP.UTF_8));
//					long id = Long.parseLong(s);
//					return id;
//				} catch (Exception e) {
//					String[] ss = s.split("'");
//					s = "Enviar Venta o Pedidos:" + "\n" + "Id:" + sale.getlId() + "\n" + "Cliente:" + sale.getCustomer().getsSocialReason() + "\n" + "Error:" + ss[1] + "\n" + "----------------------------";
//					error.add(s);
//					return -1;
//				}
//			}
//		} else {
//			connectionAlert();
//		}
//		return -1;
//	}
//
//	public long sendOrder(Sale order, User user, String keySesion, List<String> lstError) {
//		JSONObject objJson = new JSONObject();
//		JSONArray objParams = new JSONArray();
//		JSONObject objUser = new JSONObject();
//		JSONObject objOrder = new JSONObject();
//		JSONObject objPaymentSale = new JSONObject();
//
//		long id_server = 0;
//		servicesPackage = "";
//		String error = "";
//		boolean bResult = false;
//		if (isConnected()) {
//			if (order != null) {
//				try {
//					parser.sendUserParser(objUser, user);
//					parser.sendOrderParser(objOrder, order, user);
//
//					objParams.put(0, keySesion);
//					objParams.put(1, user.getsUserCode());
//					objParams.put(2, imei);
//					objParams.put(3, objUser.toString());
//					objParams.put(4, objOrder.toString());
//
//					ws = new WebServiceTask(context, servicesUrl + Constant.vMobileNewPost, servicesPackage, "GuardarPedido", objJson, null);
//					ws.setEntityArray(objParams);
//
//					// idServer
//					error = EntityUtils.toString(ws.postExecute().getEntity(), HTTP.UTF_8);
//					long id = Long.parseLong(error);
//					return id;
//
//				} catch (Exception e) {
//					String[] ss = error.split("'");
//					error = "Enviar Pedidos:" + "\n" + "Id:" + order.getlId() + "\n" + "Cliente:" + order.getCustomer().getsSocialReason() + "\n" + "Error:" + ss[1] + "\n" + "----------------------------";
//					lstError.add(error);
//					return -1;
//				}
//			}
//		} else {
//			connectionAlert();
//		}
//		return -1;
//	}
//
//	public long sendPayment(Payment payment, User user) {
//		JSONObject objJson = new JSONObject();
//		long id_server = 0;
//		servicesPackage = "cobranza";
//		boolean bResult = false;
//		if (isConnected()) {
//			if (payment != null) {
//				try {
//					configuration = context.getSharedPreferences("configuration", Context.MODE_PRIVATE);
//					id_movil = Long.parseLong(configuration.getString("idMovil", String.valueOf(user.getlIdMovil())));
//
//					objJson.put("id", payment.getId());
//					objJson.put("nro_transaccion", payment.getInvoice().getInvoiceNumber());
//					objJson.put("cuota", payment.getInvoice().getShareInvoice());
//					objJson.put("item", payment.getInvoice().getItemShareInvoice());
//					objJson.put("nro_item", payment.getNroItem());
//					objJson.put("importe_total", payment.getPayment());
//					objJson.put("fecha_pago", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(payment.getPaymentDate()));
//					objJson.put("codigo_vendedor", user.getlId());
//					objJson.put("estado", payment.getValid() == 1 ? true : false);
//					objJson.put("glosa", "movil/" + payment.getId() + "/" + payment.getInvoice().getInvoiceNumber() + "/" + payment.getInvoice().getShareInvoice() + "/" + payment.getInvoice().getItemShareInvoice() + "/" + payment.getPayment());
//					objJson.put("latitud", payment.getLatitude());
//					objJson.put("longitud", payment.getLongitude());
//					objJson.put("id_usuario_movil", user.getlIdMovil());
//					objJson.put("tiempo_inicio_edicion", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(payment.getInitialTime()));
//					objJson.put("tiempo_final_edicion", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(payment.getFinalTime()));
//					objJson.put("nro_registro", payment.getRegisterNumber());
//					JSONObject objJsonCabecera = new JSONObject();
//					objJsonCabecera.put("id", payment.getInvoice().getlIdServer());
//					objJsonCabecera.put("gestion", payment.getInvoice().getManagement());
//					objJsonCabecera.put("nro_transaccion", payment.getInvoice().getInvoiceNumber());
//					objJsonCabecera.put("cuota", payment.getInvoice().getShareInvoice());
//					objJsonCabecera.put("item", payment.getInvoice().getItemShareInvoice());
//					objJsonCabecera.put("fecha_transaccion", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(payment.getInvoice().getInvoiceDate()));
//					objJsonCabecera.put("fecha_vencimiento", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(payment.getInvoice().getExpirationDate()));
//					objJsonCabecera.put("importe_total", payment.getInvoice().getInvoiceAmount());
//					objJsonCabecera.put("codigo_cliente", payment.getInvoice().getIdCustomer());
//					objJson.put("transaccionCobranza", objJsonCabecera);
//
//					ws = new WebServiceTask(context, servicesUrl, servicesPackage, "enviarCobranza", objJson, null);
//					HttpEntity responseEntity = ws.postExecute().getEntity();
//					JSONObject items = new JSONObject(EntityUtils.toString(responseEntity, HTTP.UTF_8));
//					payment.setObservationServer(items.getString("va_obs_tr4"));
//					payment.setServerId(items.getLong("id"));
//
//					// idServer
//					return payment.getServerId();
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//					return -1;
//				}
//			}
//		} else {
//			connectionAlert();
//		}
//		return -1;
//	}
//
//	@SuppressWarnings("deprecation")
//	public long sendCustomerPhoto(Photo photo, Customer customer, User user, int index, String keySesion) {
//		servicesPackage = "cliente";
//		HttpClient httpClient = new DefaultHttpClient();
//		HttpPost postRequest = new HttpPost(servicesUrlPhoto + servicesPackage + "/" + "enviarClienteFoto2");
//		HttpResponse response = null;
//		JSONObject jsonJobject = new JSONObject();
//
//		try {
//			MultipartEntity multipartEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
//
//			jsonJobject.put("id", photo.getlNsync());
//			if (customer.getiNSync() > 0)
//				jsonJobject.put("id_cliente", customer.getiNSync());
//			else
//				jsonJobject.put("id_cliente", customer.getlIdServer());
//			jsonJobject.put("codigoCliente", "");
//			jsonJobject.put("orden", index);
//			jsonJobject.put("fecha_toma", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(Calendar.getInstance().getTime()));
//			// jsonJobject.put("fecha_toma", new SimpleDateFormat("MMM dd,yyyy", Locale.US).format(Calendar.getInstance().getTime()));
//			// jsonJobject.put("fecha_toma", Calendar.getInstance().getTime());
//			jsonJobject.put("imei", imei);
//			jsonJobject.put("ancho", 480);
//			jsonJobject.put("alto", 640);
//			jsonJobject.put("latitud", 0.0);
//			jsonJobject.put("longitude", 0.0);
//			jsonJobject.put("estado", true);
//
//			multipartEntity.addPart("id_usuario_erp", new StringBody(String.valueOf(user.getsUserCode())));
//			multipartEntity.addPart("Imei", new StringBody(String.valueOf(imei)));
//			multipartEntity.addPart("id_usuario_movil", new StringBody(String.valueOf(user.getlIdMovil())));
//			multipartEntity.addPart("clienteFoto", new StringBody(jsonJobject.toString()));
//			File f = new File(photo.getsUrl());
//			multipartEntity.addPart("imagen", new FileBody(f));
//			postRequest.setEntity(multipartEntity);
//			response = httpClient.execute(postRequest);
//			return Long.valueOf(EntityUtils.toString(response.getEntity()));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}
//
//	public long sendPhotoDelete(Photo photo, Customer customer, String keySesion) {
//		servicesPackage = "cliente";
//		JSONObject jsonJobject = new JSONObject();
//
//		try {
//			jsonJobject.put("id", photo.getlNsync());
//			if (customer.getiNSync() > 0)
//				jsonJobject.put("id_cliente", customer.getiNSync());
//			else
//				jsonJobject.put("id_cliente", customer.getlIdServer());
//			jsonJobject.put("codigoCliente", "");
//			jsonJobject.put("orden", photo.getiOrder());
//			jsonJobject.put("fecha_toma", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(Calendar.getInstance().getTime()));
//			// jsonJobject.put("fecha_toma", new SimpleDateFormat("MMM dd,yyyy", Locale.US).format(Calendar.getInstance().getTime()));
//			// jsonJobject.put("fecha_toma", Calendar.getInstance().getTime());
//			jsonJobject.put("imei", imei);
//			jsonJobject.put("ancho", 480);
//			jsonJobject.put("alto", 640);
//			jsonJobject.put("latitud", 0.0);
//			jsonJobject.put("longitude", 0.0);
//			jsonJobject.put("estado", true);
//			if (photo.getiStatus() == 1)
//				jsonJobject.put("action", "Delete");
//
//			ws = new WebServiceTask(context, servicesUrlPhoto, servicesPackage, "eliminarFotoCliente", jsonJobject, null);
//			long id = Integer.parseInt(EntityUtils.toString(ws.postExecute().getEntity(), HTTP.UTF_8));
//			return id;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}
//
//	public class task extends AsyncTask<ImageView, Progress, Result> {
//		private List<Photo> lstPhoto = new ArrayList<Photo>();
//		private ImageView view;
//
//		public task(List<Photo> lstPhoto, ImageView view) {
//			this.lstPhoto = lstPhoto;
//			this.view = view;
//		}
//
//		@Override
//		protected Result doInBackground(ImageView... params) {
//
//			return null;
//		};
//
//		@Override
//		protected void onPostExecute(Result result) {
//			for (Photo photo : lstPhoto) {
//				new AQuery(context).id(view).image(photo.getsUrl(), false, true);
//			}
//			super.onPostExecute(result);
//		}
//	}
//
//	public int actualizarSincronizar(boolean bState, User user) {
//		servicesPackage = "movil";
//		if (isConnected()) {
//			try {
//				lstAttribute.clear();
//				lstAttribute.add(String.valueOf(Long.parseLong((configuration.getString("idMovil", String.valueOf(user.getlIdMovil()))))));
//				lstAttribute.add(imei);
//				lstAttribute.add(String.valueOf(bState));
//
//				ws = new WebServiceTask(this.context, servicesUrl, servicesPackage, "actualizarSincronizar", null, lstAttribute);
//				// HttpEntity responseEntity = ws.getExecute().getEntity();
//				return (EntityUtils.toString(ws.getExecute().getEntity())).equalsIgnoreCase("true") ? 1 : 0;
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else {
//			connectionAlert();
//		}
//		return 0;
//	}
//
//	// public int actualizarDiaCerrado(boolean bState, User user) {
//	// servicesPackage = "movil";
//	// if (isConnected()) {
//	// try {
//	// lstAttribute.clear();
//	// lstAttribute.add(String.valueOf(Long.parseLong(configuration.getString("idMovil", String.valueOf(user.getlIdMovil())))));
//	// lstAttribute.add(imei);
//	// lstAttribute.add(String.valueOf(bState));
//	//
//	// ws = new WebServiceTask(this.context, servicesUrl, servicesPackage, "actualizarDiaCerrado", null, lstAttribute);
//	// return (EntityUtils.toString(ws.getExecute().getEntity())).equalsIgnoreCase("true") ? 1 : 0;
//	//
//	// } catch (Exception e) {
//	// e.printStackTrace();
//	// }
//	// } else {
//	// connectionAlert();
//	// }
//	// return 0;
//	// }
//
//	public boolean actualizarHistorialSincronizacion(User user, boolean b) {
//		boolean bResult = false;
//		servicesPackage = "movil";
//		if (isConnected()) {
//			try {
//				lstAttribute.clear();
//				lstAttribute.add(String.valueOf(user.getlIdMovil()));
//				lstAttribute.add(imei);
//				lstAttribute.add(b ? "true" : "false");
//
//				ws = new WebServiceTask(this.context, servicesUrl + Constant.vMobileNewPost + "/", servicesPackage, "actualizarSincronizar", null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//
//				String result = EntityUtils.toString(responseEntity, HTTP.UTF_8);
//
//				bResult = Boolean.valueOf(result);
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else {
//			connectionAlert();
//		}
//		return bResult;
//	}
//
//	public boolean actualizarDiaCerredado(User user, boolean b) {
//		boolean bResult = false;
//		servicesPackage = "movil";
//		if (isConnected()) {
//			try {
//				lstAttribute.clear();
//				lstAttribute.add(String.valueOf(user.getlIdMovil()));
//				lstAttribute.add(imei);
//				lstAttribute.add(b ? "true" : "false");
//
//				ws = new WebServiceTask(this.context, servicesUrl + Constant.vMobileNewPost + "/", servicesPackage, "actualizarDiaCerrado", null, lstAttribute);
//				HttpEntity responseEntity = ws.getExecute().getEntity();
//				String result = EntityUtils.toString(responseEntity, HTTP.UTF_8);
//
//				bResult = Boolean.valueOf(result);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else {
//			connectionAlert();
//		}
//		return bResult;
//	}
//
//	public boolean isConnected() {
//		if (Functions.isConnectedToWifi(context)) {
//			servicesUrl = configuration.getString("webservice", "");
//			return true;
//		} else {
//			if (Functions.isConnectedToMobile(context)) {
//				servicesUrl = configuration.getString("webservicepublic", "");
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public void connectionAlert() {
//		((Activity) this.context).runOnUiThread(new Runnable() {
//			public void run() {
//				final Dialog dialog = new Dialog(context);
//				LayoutInflater inflater = ((Activity) context).getLayoutInflater();
//				View viewDialog = inflater.inflate(R.layout.dialog_anulation, null, true);
//
//				TextView tvTitle = (TextView) viewDialog.findViewById(R.id.tvAnulationTitle);
//				TextView tvDescription = (TextView) viewDialog.findViewById(R.id.tvAnulationDescription);
//				Button btnPositive = (Button) viewDialog.findViewById(R.id.btnAnulationPositive);
//				Button btnCancel = (Button) viewDialog.findViewById(R.id.btnAnulationCancel);
//				tvTitle.setText("Error de conexion");
//				tvDescription.setText("No tiene ningun tipo de conexion para sincronizarce.");
//				dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//				dialog.setContentView(viewDialog);
//
//				btnPositive.setOnClickListener(new OnClickListener() {
//
//					@Override
//					public void onClick(View v) {
//						dialog.dismiss();
//						context.startActivity(new Intent(context, ConfigurationActivity.class));
//					}
//				});
//
//				btnCancel.setOnClickListener(new OnClickListener() {
//
//					@Override
//					public void onClick(View v) {
//						dialog.dismiss();
//					}
//				});
//
//				dialog.show();
//			}
//		});
//	}

}

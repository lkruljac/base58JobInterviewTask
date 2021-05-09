using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public class RequestService
    {
        private WebRequest _request;
        UTF8Encoding enc;
        public RequestService(string url)
        {
            enc = new UTF8Encoding();
            _request = WebRequest.Create(url);
            _request.ContentType = "application/json; charset=UTF-8";
            _request.UseDefaultCredentials = true;
        }

        public string GetRequest()
        {
            _request.Method = "GET";
            string content;
            try
            {
                WebResponse wr = _request.GetResponse();
                Stream receiveStream = wr.GetResponseStream();
                StreamReader reader = new StreamReader(receiveStream, Encoding.UTF8);
                content = reader.ReadToEnd();
            }
            catch
            {
                throw new System.Exception("GET DIDN'T WORK");
            }
            return content;
        }

        public bool IsServiceOnline()
        {
            _request.Method = "GET";
            string content;
            WebResponse wr;
            try
            {
                wr = _request.GetResponse();
                Stream receiveStream = wr.GetResponseStream();
                StreamReader reader = new StreamReader(receiveStream, Encoding.UTF8);
                content = reader.ReadToEnd();
            }
            catch
            {
                return false;
            }
            return true;
        }


    }
}
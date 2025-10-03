import Foundation
import SwiftUI

let filePath =  "scrapedParagraphData"
let filePath1 = "scrapedPostData"
let filePath2 = "scrapedImageData"

@Observable
class ParagraphList: Codable {
	public var paraList: [ParagraphModel] = []
	
}
@Observable
class ImageList: Codable {
	public var imageList: [ImageModel] = []
	
}
@Observable
class PostList: Codable {
	public var postList: [PostModel] = []
	
}


@Observable
class ultimateList {
	var paragraphList = ParagraphList() {
		didSet {
			saveData()
		}
	}
	var postList = PostList() {
		didSet {
			saveData()
		}
	}
	var imageList = ImageList() {
		didSet {
			saveData()
		}
	}
	
	var imgDownloadPath: String? = nil
	var allPaths: [String] = []
	var allImgs: [Image] = []
	
	
	func getFromJSON() {
		self.paragraphList.paraList = Bundle.main.decode(filePath)
		self.postList.postList = Bundle.main.decode(filePath1)
		self.imageList.imageList =  Bundle.main.decode(filePath2)
	}
	
	func saveData() {
		UserDefaults.setValue(self.paragraphList, forKey: "paraList")
		UserDefaults.setValue(self.postList, forKey: "postList")
		UserDefaults.setValue(self.imageList, forKey: "imageList")
	}
	func getData() {
		self.paragraphList = UserDefaults.value(forKey: "paraList") as? ParagraphList ?? ParagraphList()
		self.postList = UserDefaults.value(forKey: "postList") as? PostList ?? PostList()
		self.imageList = UserDefaults.value(forKey: "imageList") as? ImageList ?? ImageList()
	}
	
	
	func removeDataIMG(index: Int) {
		self.imageList.imageList.remove(at: index)
	}
	func removeDataPAR(index: Int) {
		self.paragraphList.paraList.remove(at: index)
	}
	func removeDataPOS(index: Int) {
		self.postList.postList.remove(at: index)
	}
	
	
	
	init() {
		
		print("initializing")
		
		
		self.getFromJSON()
		
		for imgModel in self.imageList.imageList {
			
			if let url = URL(string: imgModel.url) {
				FileDownloader.loadFileAsync(url: url) { path in
					
					if let path = path {
						self.imgDownloadPath = path
						self.allPaths.append(path)
						
						let fileURL = URL(filePath: path)
						
						let data = try? Data(contentsOf: fileURL)
						
						if let data = data {
							let uiImage = UIImage(data: data)
							let image = Image(uiImage: uiImage!)
							self.allImgs.append(image)
							print("image")
						} else {
							print("data has no value")
						}
					}
				}
			} else {
				print("error: continued the loop")
			}
		}
		
	}
	
	func loadImageFromFile(path: String) {
		let fileURL = URL(filePath: path)
		do {
			let data = try Data(contentsOf: fileURL)
			if let uiImage = UIImage(data: data) {
				let image = Image(uiImage: uiImage)
				print("image")
				self.allImgs.append(image)
			}
		} catch {
			print("error occurred when loading file")
		}
		
	}
	
}


class FileDownloader {
	
	static func loadFileSync(url: URL, completion: @escaping (String?) -> Void) {
		let documentsUrl = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask).first!
		let destinationUrl = documentsUrl.appendingPathComponent(url.lastPathComponent)
		
		if FileManager().fileExists(atPath: destinationUrl.path) {
			completion(destinationUrl.path)
		} else if let dataFromURL = NSData(contentsOf: url) {
			if dataFromURL.write(to: destinationUrl, atomically: true) {
				completion(destinationUrl.path)
			} else {
				print("error when saving file")
				completion(nil)
			}
		} else {
			print("file doesn't exist")
			completion(nil)
		}
		
	}
	
	static func loadFileAsync(url: URL, completion: @escaping (String?) -> Void) {
		let documentsUrl =  FileManager.default.urls(for: .documentDirectory, in: .userDomainMask).first!
		let destinationUrl = documentsUrl.appendingPathComponent(url.lastPathComponent)
		
		if FileManager().fileExists(atPath: destinationUrl.path) {
			completion(destinationUrl.path)
			
		} else {
			let session = URLSession(configuration: URLSessionConfiguration.default, delegate: nil, delegateQueue: nil)
			var request = URLRequest(url: url)
			request.httpMethod = "GET"
			let task = session.dataTask(with: request, completionHandler: {
				data, response, error in
				if error == nil {
					if let response = response as? HTTPURLResponse {
						if response.statusCode == 200 {
							if let data = data {
								if let _ = try? data.write(to: destinationUrl, options: Data.WritingOptions.atomic) {
									completion(destinationUrl.path)
								} else {
									print("error when getting the data")
									completion(nil)
								}
							} else {
								print("data is nil")
								completion(nil)
							}
						}
					}
				} else {
					print("weird errors occurred")
					completion(nil)
				}
			})
			
			task.resume()
		}
	}
	
}



// MARK: - ImageList
@Observable
class ImageModel: Codable {
	//	let id: String = UUID().uuidString
	
	let url: String
	let description: String
	let widthAndHeight: [Int]
	
	init(url: String, description: String, widthAndHeight: [Int]) {
		self.url = url
		self.description = description
		self.widthAndHeight = widthAndHeight
	}
}

// MARK: - ParaList
@Observable
class ParagraphModel: Codable {
	//	let id: String = UUID().uuidString
	
	let paragraph: String
	let order: Int
	
	init(paragraph: String, order: Int) {
		self.paragraph = paragraph
		self.order = order
	}
}

// MARK: - PostList
@Observable
class PostModel: Codable {
	//	let id: String = UUID().uuidString
	
	let post: String
	
	init(post: String) {
		self.post = post
	}
}



extension Bundle {
	func decode<T: Decodable>(_ resource: String,
							  withExtension ext: String = ".json") -> T {
		guard let url = self.url(forResource: resource, withExtension: ext) else {
			fatalError("Could not find \(resource).\(ext) in bundle.")
		}
		
		do {
			let data = try Data(contentsOf: url)
			let decoder = JSONDecoder()
			return try decoder.decode(T.self, from: data)
		} catch {
			fatalError("Failed to decode \(resource).\(ext): \(error)")
		}
	}
}

